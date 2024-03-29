package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.services.abstracts.ProductService;
import com.tobeto.java4aPair4.services.dtos.requests.product.AddProductRequest;
import com.tobeto.java4aPair4.services.dtos.requests.product.UpdateProductRequest;
import com.tobeto.java4aPair4.services.dtos.responses.product.AddProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.ListProductResponse;
import com.tobeto.java4aPair4.services.dtos.responses.product.UpdateProductResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ListProductResponse> getAll() {
		return productService.getAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AddProductResponse add(@RequestBody @Valid AddProductRequest request) {
		return productService.add(request);
	}
	
	@PutMapping
	public UpdateProductResponse update(@RequestBody @Valid UpdateProductRequest request) {
		return productService.update(request);
	}
	
	@DeleteMapping
	public void delete(@RequestParam int id) {
		productService.delete(id);
	}
}
