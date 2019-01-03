package com.spring.rest.provider.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.provider.dto.VendorDTO;
import com.spring.rest.provider.service.VendorService;

@RestController
@RequestMapping(VendorController.BASE_URL)
public class VendorController {
	public static final String BASE_URL = "/api/v1/vendors/";
		
	VendorService vendorService;
	
	public VendorController(VendorService vendorService) {
		this.vendorService = vendorService;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<VendorDTO> getAllVendors(){
		List<VendorDTO> vendors = vendorService.getAllVendors();
		return vendors;
	}

	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDTO getVendorById(@PathVariable Long id){
		VendorDTO vendor = vendorService.getVendorById(id);
		return vendor;
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VendorDTO createVendor(@RequestBody VendorDTO vendorDTO) {
		VendorDTO vendor = vendorService.createNewVendor(vendorDTO);
		return vendor;
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDTO updateVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
		VendorDTO vendor = vendorService.updateVendor(vendorDTO, id);
		return vendor;		
	}
	
	@PatchMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDTO patchVendor(@RequestBody VendorDTO vendorDTO, @PathVariable Long id) {
		VendorDTO vendor = vendorService.patchVendor(vendorDTO, id);
		return vendor;		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteVendor(@PathVariable Long id) {
		vendorService.deleteVendor(id);
	}
	
	
}
