package com.tobeto.java4aPair4.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.java4aPair4.services.abstracts.ProductService;
import com.tobeto.java4aPair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForUpdatingDto;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ProductForListingDto> getAll() {
		return productService.getAll();
	}

	@PostMapping
	public void add(@RequestBody ProductForAddingDto productForAddingDto) {
		productService.add(productForAddingDto);
	}
	
	@PutMapping
	public void update(@RequestBody ProductForUpdatingDto productForUpdatingDto) {
		productService.update(productForUpdatingDto);
	}
	
	@DeleteMapping
	public void delete(@RequestParam int id) {
		productService.delete(id);
	}
}
