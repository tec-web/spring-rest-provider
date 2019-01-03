package com.spring.rest.provider.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.provider.domain.Category;
import com.spring.rest.provider.dto.CategoryDTO;
import com.spring.rest.provider.repository.CategoryRepository;
import com.spring.rest.provider.service.CategoryService;
import com.spring.rest.provider.service.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService{	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List<CategoryDTO> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		
		/*TODO: Look for a better implementation*/
		List<CategoryDTO> result = new ArrayList<>();
		
		for(Category category : categories) {
			CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName());
			result.add(categoryDTO);
		}
		
		return result;
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {		
		Category category = categoryRepository.findByName(name);
		CategoryDTO result = null;
		
		if(category != null) {
			result = new CategoryDTO(category.getId(), category.getName());
		}else {
			throw new ResourceNotFoundException("Entity not found");
		}
		
		return result;
	}
}
