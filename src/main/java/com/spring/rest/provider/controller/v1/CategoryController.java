package com.spring.rest.provider.controller.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.provider.dto.CategoryDTO;
import com.spring.rest.provider.service.CategoryService;

@RestController
@RequestMapping("/api/v1/categories/")
public class CategoryController {
	CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryDTO> getAllCategories(){
		List<CategoryDTO> categories = categoryService.getAllCategories();
				
		return categories;
	}
	
	@GetMapping("{name}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO getCategoryByName(@PathVariable String name ) {
		CategoryDTO category = categoryService.getCategoryByName(name);
		
		return category;
	}
}
