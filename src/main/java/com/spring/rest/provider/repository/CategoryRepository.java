package com.spring.rest.provider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.provider.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	public Category findByName(String name);
}
