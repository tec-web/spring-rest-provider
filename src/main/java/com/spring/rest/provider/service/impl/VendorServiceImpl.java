package com.spring.rest.provider.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.provider.domain.Vendor;
import com.spring.rest.provider.dto.VendorDTO;
import com.spring.rest.provider.repository.VendorRepository;
import com.spring.rest.provider.service.ResourceNotFoundException;
import com.spring.rest.provider.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	VendorRepository vendorRepository;

	public VendorServiceImpl(VendorRepository vendorRepository) {
		this.vendorRepository = vendorRepository;
	}
	
	@Override
	public List<VendorDTO> getAllVendors() {
		List<Vendor> vendors = vendorRepository.findAll();
		
		List<VendorDTO> vendorsDTO = vendors.stream()
				.map( v -> {
							VendorDTO vendorDTO = new VendorDTO();
							vendorDTO.setId(v.getId());
							vendorDTO.setName(v.getName());
							vendorDTO.setVendorUrl("/ap1/v1/vendors/" + v.getId());
							return vendorDTO;
						})
				.collect(Collectors.toList());
		
		return vendorsDTO;
	}

	@Override
	public VendorDTO getVendorById(Long id) {
		VendorDTO vendorDTO = null;
		Optional<Vendor> vendor = vendorRepository.findById(id);
		
		if(vendor.isPresent()) {
			vendorDTO = new VendorDTO();
			vendorDTO.setId(vendor.get().getId());
			vendorDTO.setName(vendor.get().getName());
			vendorDTO.setVendorUrl("/ap1/v1/vendors/" + vendor.get().getId());
		}else {
			throw new ResourceNotFoundException("Entity Not Found");
		}
		
		return vendorDTO;
	}

	@Override
	public VendorDTO createNewVendor(VendorDTO vendorDTO) {
		Vendor vendor = new Vendor();
		vendor.setName(vendorDTO.getName());
		
		VendorDTO newVendorDTO = this.saveVendor(vendor);
		
		return newVendorDTO;
	}
	
	private VendorDTO saveVendor(Vendor vendor) {		
		Vendor newVendor = vendorRepository.save(vendor);
		
		VendorDTO vendorDTO = new VendorDTO();
		vendorDTO.setId(newVendor.getId());
		vendorDTO.setName(newVendor.getName());
		vendorDTO.setVendorUrl("/api/v1/vendors/"+ newVendor.getId());
		
		return vendorDTO;
	}

	@Override
	public VendorDTO updateVendor(VendorDTO vendorDTO, Long id) {
		Vendor vendor = new Vendor();
		vendor.setId(id);
		vendor.setName(vendorDTO.getName());
		
		VendorDTO newVendorDTO = this.saveVendor(vendor);
		
		return newVendorDTO;
	}

	@Override
	public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
		Vendor vendor = vendorRepository.getOne(id);
		
		if(vendorDTO.getName() != null) {
			vendor.setName(vendorDTO.getName());
		}
		
		VendorDTO newVendorDTO = this.saveVendor(vendor);
		newVendorDTO.setVendorUrl("/api/v1/vendors/" + id);
		
		return newVendorDTO;
	}

	@Override
	public void deleteVendor(Long id) {
		vendorRepository.deleteById(id);
	}
}
