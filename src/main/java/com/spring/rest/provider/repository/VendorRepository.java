package com.spring.rest.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.provider.domain.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
