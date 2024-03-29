package com.tobeto.java4aPair4.services.abstracts;

import java.util.List;

import com.tobeto.java4aPair4.services.dtos.category.CategoryForAddingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForListingDto;
import com.tobeto.java4aPair4.services.dtos.category.CategoryForUpdatingDto;

public interface CategoryService {
	void add(CategoryForAddingDto dto);
	void update(CategoryForUpdatingDto dto);
	void delete(int id);
	List<CategoryForListingDto> getAll();
	CategoryForListingDto getById(int id);
}
