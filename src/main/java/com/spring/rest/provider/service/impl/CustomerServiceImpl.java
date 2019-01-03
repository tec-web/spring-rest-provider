package com.spring.rest.provider.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.rest.provider.domain.Customer;
import com.spring.rest.provider.dto.CustomerDTO;
import com.spring.rest.provider.repository.CustomerRepository;
import com.spring.rest.provider.service.CustomerService;
import com.spring.rest.provider.service.ResourceNotFoundException;

@Service
public class CustomerServiceImpl implements CustomerService {
	CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@Override
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		
		List<CustomerDTO> result = customers
				.stream()
				.map(
					c -> {
						CustomerDTO customerDTO = new CustomerDTO();
						customerDTO.setFirstname(c.getFirstname());
						customerDTO.setLastname(c.getLastname());
						customerDTO.setCustomerUrl("/api/customers/" + c.getId());
						return customerDTO;
					})
				.collect(Collectors.toList());
	
		return result;
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		
		if(customer.isPresent()) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setFirstname(customer.get().getFirstname());
			customerDTO.setLastname(customer.get().getLastname());
			customerDTO.setCustomerUrl("/api/customers/" + customer.get().getId());
			
			return customerDTO;
		}else {
			throw new ResourceNotFoundException("Entity not found");
		}
	}

	@Override
	public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setFirstname(customerDTO.getFirstname());
		customer.setLastname(customerDTO.getLastname());
		
		CustomerDTO newCustomerDTO = saveCustomer(customer);
		
		return newCustomerDTO;
	}
	
	private CustomerDTO saveCustomer(Customer customer) {						
		Customer newCustomer = customerRepository.save(customer);
		
		CustomerDTO newCustomerDTO = new CustomerDTO();
		newCustomerDTO.setFirstname(newCustomer.getFirstname());
		newCustomerDTO.setLastname(newCustomer.getLastname());
		newCustomerDTO.setCustomerUrl("/api/v1/customers/" + newCustomer.getId());
			
		return newCustomerDTO;				
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO, Long id) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFirstname(customerDTO.getFirstname());
		customer.setLastname(customerDTO.getLastname());
		
		CustomerDTO newCustomerDTO = saveCustomer(customer);
	
		return newCustomerDTO;
	}

	@Override
	public CustomerDTO patchCustomer(CustomerDTO customerDTO, Long id) {
		Customer storedCustomer = customerRepository.getOne(id);
		
		if(customerDTO.getFirstname() != null) {
			storedCustomer.setFirstname(customerDTO.getFirstname());
		}
		
		if(customerDTO.getLastname() != null) {
			storedCustomer.setLastname(customerDTO.getLastname());
		}
		
		CustomerDTO currentCustomer = this.saveCustomer(storedCustomer);
		
		return currentCustomer;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);		
	}
}
