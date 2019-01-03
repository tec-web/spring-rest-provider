package com.spring.rest.provider.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.rest.provider.dto.VendorDTO;
import com.spring.rest.provider.service.VendorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VendorServiceImplTestIT {

	@Autowired
	VendorService vendorService;
	
	@Test
	public void testGetAllVendors() {
		List<VendorDTO> vendors = vendorService.getAllVendors();
		
		assertEquals(3, vendors.size());
	}

}
