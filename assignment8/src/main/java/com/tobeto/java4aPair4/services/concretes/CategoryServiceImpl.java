package com.tobeto.java4aPair4.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4aPair4.entities.Category;
import com.tobeto.java4aPair4.repositories.CategoryRepository;
import com.tobeto.java4aPair4.services.abstracts.CategoryService;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForUpdatingDto;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public void add(CategoryForAddingDto dto) {
		if(dto.getName().length() < 2)
			throw new RuntimeException("Kategori adı 2'den fazla karaktere sahip olmalıdır.");
		
		Category category = new Category();
		category.setName(dto.getName());
		categoryRepository.save(category);
	}
	
	@Override
	public void update(CategoryForUpdatingDto dto) {
	    String name = dto.getName();
	    System.out.println("dto ID:" + dto.getId());
	    if (name.length() < 2)
	        throw new RuntimeException("Kategori adı 2'den fazla karaktere sahip olmalıdır.");
	  

	    Category category = new Category();
	    category.setId(dto.getId());
	    category.setName(name);
	    categoryRepository.save(category);
	}
	
	@Override
	public void delete(int id) {
		Category category = categoryRepository.findById(id).orElseThrow();
		categoryRepository.delete(category);
	}
	
	@Override
	public List<CategoryForListingDto> getAll() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryForListingDto> categoryDtoList = new ArrayList<CategoryForListingDto>();
		for(Category category : categoryList) {
			CategoryForListingDto dto = new CategoryForListingDto();
			dto.setName(category.getName());
			dto.setId(category.getId());
			categoryDtoList.add(dto);
		}
		return categoryDtoList;
	}
	
	@Override
	public CategoryForListingDto getById(int id) {
		CategoryForListingDto dto = new CategoryForListingDto();
		Category category = categoryRepository.findById(id).orElseThrow();
		dto.setName(category.getName());
		return dto;
		}
	
}
