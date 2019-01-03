package com.spring.rest.provider.service;

import java.util.List;

import com.spring.rest.provider.dto.CategoryDTO;

public interface CategoryService{
	public List<CategoryDTO> getAllCategories();
	public CategoryDTO getCategoryByName(String name);
}
