package com.spring.rest.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.provider.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
}
