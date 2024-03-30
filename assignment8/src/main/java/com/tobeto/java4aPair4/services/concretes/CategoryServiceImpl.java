package com.tobeto.java4aPair4.services.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tobeto.java4aPair4.entities.Category;
import com.tobeto.java4aPair4.repositories.CategoryRepository;
import com.tobeto.java4aPair4.services.abstracts.CategoryService;
import com.tobeto.java4aPair4.services.dtos.requests.category.AddCategoryRequest;
import com.tobeto.java4aPair4.services.dtos.requests.category.UpdateCategoryRequest;
import com.tobeto.java4aPair4.services.dtos.responses.category.AddCategoryResponse;
import com.tobeto.java4aPair4.services.dtos.responses.category.ListCategoryResponse;
import com.tobeto.java4aPair4.services.dtos.responses.category.UpdateCategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public AddCategoryResponse add(AddCategoryRequest request) {
		categoryWithSameNameShouldNotExist(request.getName());

		Category category = new Category();
		category.setName(request.getName());
		Category savedCategory = categoryRepository.save(category);
		AddCategoryResponse response = new AddCategoryResponse(savedCategory.getName());
		return response;
	}

	@Override
	public UpdateCategoryResponse update(UpdateCategoryRequest request) {

		Category category = new Category();
		category.setId(request.getId());
		category.setName(request.getName());
		categoryRepository.save(category);
		Category savedCategory = categoryRepository.save(category);
		UpdateCategoryResponse response = new UpdateCategoryResponse(savedCategory.getId(), savedCategory.getName());
		return response;
	}

	@Override
	public void delete(int id) {
		Category category = categoryRepository.findById(id).orElseThrow();
		categoryRepository.delete(category);
	}

	@Override
	public List<ListCategoryResponse> getAll() {
		List<Category> categoryList = categoryRepository.findAll();
		List<ListCategoryResponse> categoryResponseList = new ArrayList<ListCategoryResponse>();
		for (Category category : categoryList) {
			ListCategoryResponse response = new ListCategoryResponse();
			response.setName(category.getName());
			response.setId(category.getId());
			categoryResponseList.add(response);
		}
		return categoryResponseList;
	}

	@Override
	public ListCategoryResponse getById(int id) {
		ListCategoryResponse response = new ListCategoryResponse();
		Category category = categoryRepository.findById(id).orElseThrow();
		response.setName(category.getName());
		return response;
	}

	private void categoryWithSameNameShouldNotExist(String categoryName) {
		Optional<Category> categoryWithSameName = categoryRepository.findByNameIgnoreCase(categoryName);

		if (categoryWithSameName.isPresent())
			throw new RuntimeException("Aynı isimde bir ürün zaten var.");
	}

}