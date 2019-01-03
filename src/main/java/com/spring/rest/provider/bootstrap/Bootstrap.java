package com.spring.rest.provider.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.rest.provider.domain.Category;
import com.spring.rest.provider.domain.Customer;
import com.spring.rest.provider.domain.Vendor;
import com.spring.rest.provider.repository.CategoryRepository;
import com.spring.rest.provider.repository.CustomerRepository;
import com.spring.rest.provider.repository.VendorRepository;

@Component
public class Bootstrap implements CommandLineRunner{
	private CategoryRepository categoryRepository;
	private CustomerRepository customerRepository;
	private VendorRepository vendorRepository;
	
	public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, 
			VendorRepository vendorRepository) {
		this.categoryRepository = categoryRepository;
		this.customerRepository = customerRepository;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public void run(String... args) throws Exception {
	    loadCategories();
	    loadCustomers();
	    loadVendors();
	}

	private void loadCategories() {
		Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);

        System.out.println("Data Loaded = " + categoryRepository.count() );
	}
	
	private void loadCustomers() {
	     //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());		
	}

	private void loadVendors() {
		Vendor vendorOne = new Vendor();
		vendorOne.setId(1L);
		vendorOne.setName("Western Tasty Fruits Ltd.");
		
		Vendor vendorTwo = new Vendor();
		vendorTwo.setId(2L);
		vendorTwo.setName("Exotic Fruits Company");
		
		Vendor vendorThree = new Vendor();
		vendorThree.setId(3L);
		vendorThree.setName("Nuts for Nuts Company");	
		
		vendorRepository.save(vendorOne);
		vendorRepository.save(vendorTwo);
		vendorRepository.save(vendorThree);
		
		System.out.println("Vendors Loaded: " + vendorRepository.count());
	}
}
