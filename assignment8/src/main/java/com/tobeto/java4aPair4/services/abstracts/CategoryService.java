package com.tobeto.java4aPair4.services.abstracts;

import java.util.List;

import com.tobeto.java4aPair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4aPair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4aPair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4aPair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4aPair4.services.dtos.responses.category.UpdateCategoryResponse;

public interface CategoryService {
	AddCategoryResponse add(AddCategoryRequest request);

	UpdateCategoryResponse update(UpdateCategoryRequest request);

	void delete(int id);

	List<ListCategoryResponse> getAll();

	ListCategoryResponse getById(int id);
}
