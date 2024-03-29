package com.tobeto.java4aPair4.services.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tobeto.java4aPair4.entities.Product;
import com.tobeto.java4aPair4.entities.Category;
import com.tobeto.java4aPair4.repositories.CategoryRepository;
import com.tobeto.java4aPair4.repositories.ProductRepository;
import com.tobeto.java4aPair4.services.abstracts.ProductService;
import com.tobeto.java4aPair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4aPair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4aPair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.UpdateProductResponse;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;

	public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
		super();
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	

	@Override
	public AddProductResponse add(AddProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());
		
		Product product = new Product();
		product.setPrice(request.getPrice());
		product.setName(request.getName());
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		product.setCategory(category);
		Product savedProduct = productRepository.save(product);
		AddProductResponse response = new AddProductResponse(savedProduct.getId(), category.getId(), savedProduct.getName(), savedProduct.getPrice());
		return response;
	}

	@Override
	public UpdateProductResponse update(UpdateProductRequest request) {
		productWithSameNameShouldNotExist(request.getName());
		
		Product product = new Product();
		product.setId(request.getId());
		product.setPrice(request.getPrice());
		product.setName(request.getName());
		Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow();
		product.setCategory(category);
		Product savedProduct = productRepository.save(product);
		UpdateProductResponse response = new UpdateProductResponse(savedProduct.getId(), category.getId(), savedProduct.getName(), savedProduct.getPrice());
		return response;
		
	}

	@Override
	public void delete(int id) {
		Product product = productRepository.findById(id).orElseThrow();
		productRepository.delete(product);
	}

	@Override
	public List<ListProductResponse> getAll() {
		List<Product> productList = productRepository.findAll();
		List<ListProductResponse> productResponseList = new ArrayList<ListProductResponse>();
		for (Product product : productList) {
			ListProductResponse response = new ListProductResponse();
			response.setId(product.getId());
			response.setCategoryId(product.getCategory().getId());
			response.setName(product.getName());
			response.setPrice(product.getPrice());
			productResponseList.add(response);
		}
		return productResponseList;
	}

	@Override
	public ListProductResponse getById(int id) {
		ListProductResponse response = new ListProductResponse();
		Product product = productRepository.findById(id).orElseThrow();
		response.setName(product.getName());
		response.setPrice(product.getPrice());
		return response;
	}
	
	 private void productWithSameNameShouldNotExist(String productName)
	    {
	        Optional<Product> productWithSameName = productRepository.findByNameIgnoreCase(productName);

	        if(productWithSameName.isPresent())
	            throw new RuntimeException("Aynı isimde bir ürün zaten var.");
	    }
	
}
