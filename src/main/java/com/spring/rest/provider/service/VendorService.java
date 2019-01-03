package com.spring.rest.provider.service;

import java.util.List;

import com.spring.rest.provider.dto.VendorDTO;

public interface VendorService {
	public List<VendorDTO> getAllVendors();
	public VendorDTO getVendorById(Long Id);
	public VendorDTO createNewVendor(VendorDTO vendorDTO);
	public VendorDTO updateVendor(VendorDTO vendorDTO, Long Id);
	public VendorDTO patchVendor(VendorDTO vendorDTO, Long id);
	public void deleteVendor(Long id);
}
