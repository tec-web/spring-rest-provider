package com.spring.rest.provider.service;

import java.util.List;

import com.spring.rest.provider.dto.CustomerDTO;

public interface CustomerService {
	public List<CustomerDTO> getAllCustomers();
	public CustomerDTO getCustomerById(Long id);
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO);
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id);
	public CustomerDTO patchCustomer(CustomerDTO customerDTO, Long id);
	public void deleteCustomer(Long id);
}
