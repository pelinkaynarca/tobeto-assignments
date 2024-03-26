package com.tobeto.java4aPair4.services.abstracts;

import java.util.List;

import com.tobeto.java4aPair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForUpdatingDto;

public interface ProductService {
	void add(ProductForAddingDto dto);
	void update(ProductForUpdatingDto dto);
	void delete(int id);
	List<ProductForListingDto> getAll();
	ProductForListingDto getById(int id);
}
