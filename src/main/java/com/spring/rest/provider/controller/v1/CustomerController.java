package com.spring.rest.provider.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.rest.provider.dto.CustomerDTO;
import com.spring.rest.provider.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(description = "This is the Customer Controller")
@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {
	
	public static final String BASE_URL = "/api/v1/customers/";
	
	CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@ApiOperation(value="This will get a list of all customers", notes = "Notes: To be defined by the API designer")
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
		List<CustomerDTO> customers = customerService.getAllCustomers();
		ResponseEntity<List<CustomerDTO>> response = 
				new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	
		return response;
	}
	
	@ApiOperation(value="This will get a customer by id")
	@GetMapping("{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id){
		CustomerDTO customerDTO = customerService.getCustomerById(id);
		ResponseEntity<CustomerDTO> response = 
				new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
		
		return response;
	}
	
	@ApiOperation(value="This will create a new customer")
	@PostMapping
	public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
		CustomerDTO newCustomer = customerService.createNewCustomer(customerDTO);
		ResponseEntity<CustomerDTO> response = 
				new ResponseEntity<CustomerDTO>(newCustomer, HttpStatus.CREATED);
		
		return response;
	}
	
	
	@ApiOperation(value="This will update an existing customer")
	@PutMapping("{id}")
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
		CustomerDTO newCustomer = customerService.updateCustomer(customerDTO, id);		
		
		ResponseEntity<CustomerDTO> response = 
				new ResponseEntity<CustomerDTO>(newCustomer, HttpStatus.OK);
		
		return response;
	}
	
	@ApiOperation(value="This will partially update an existing customer")
	@PatchMapping("{id}")
	public ResponseEntity<CustomerDTO> patchCustomer(@PathVariable Long id, @RequestBody CustomerDTO customerDTO){
		CustomerDTO newCustomer = customerService.patchCustomer(customerDTO, id);		
		
		ResponseEntity<CustomerDTO> response = 
				new ResponseEntity<CustomerDTO>(newCustomer, HttpStatus.OK);
		
		return response;
	}	
	
	@ApiOperation(value="This will delete a customer")
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
		customerService.deleteCustomer(id);		
		
		ResponseEntity<Void> response = 
				new ResponseEntity<Void>(HttpStatus.OK);
		
		return response;
	}		
}
