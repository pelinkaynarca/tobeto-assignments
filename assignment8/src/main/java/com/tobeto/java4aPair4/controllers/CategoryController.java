package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.services.abstracts.CategoryService;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForUpdatingDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public List<CategoryForListingDto> getAll() {
		return categoryService.getAll();
	}
	
	@PostMapping
	public void add(@RequestBody CategoryForAddingDto categoryForAddingDto) {
		categoryService.add(categoryForAddingDto);
	}
	
	@PutMapping
	public void update(@RequestBody CategoryForUpdatingDto categoryForUpdatingDto) {
		categoryService.update(categoryForUpdatingDto);
	}
	
	@DeleteMapping
	public void delete(@RequestParam int id) {
		categoryService.delete(id);
	}
}
