package com.tobeto.java4aPair4.services.abstracts;

import java.util.List;

import com.tobeto.java4aPair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4aPair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4aPair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.UpdateProductResponse;

public interface ProductService {
	AddProductResponse add(AddProductRequest request);
	UpdateProductResponse update(UpdateProductRequest request);
	void delete(int id);
	List<ListProductResponse> getAll();
	ListProductResponse getById(int id);
}
