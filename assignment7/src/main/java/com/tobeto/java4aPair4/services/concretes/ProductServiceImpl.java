package com.tobeto.java4aPair4.services.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.java4aPair4.entities.Product;
import com.tobeto.java4aPair4.entities.Category;
import com.tobeto.java4aPair4.repositories.CategoryRepository;
import com.tobeto.java4aPair4.repositories.ProductRepository;
import com.tobeto.java4aPair4.services.abstracts.ProductService;
import com.tobeto.java4aPair4.services.dtos.product.ProductForAddingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForListingDto;
import com.tobeto.java4aPair4.services.dtos.product.ProductForUpdatingDto;

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
	public void add(ProductForAddingDto dto) {
		if(dto.getPrice() <= 0)
			throw new RuntimeException("Ürün fiyatı 0'dan büyük olmalıdır.");
		
		Product product = new Product();
		product.setPrice(dto.getPrice());
		product.setName(dto.getName());
		Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow();
		product.setCategory(category);
		productRepository.save(product);
	}

	@Override
	public void update(ProductForUpdatingDto dto) {
		if(dto.getPrice() <= 0)
			throw new RuntimeException("Ürün fiyatı 0'dan büyük olmalıdır.");
		
		Product product = new Product();
		product.setId(dto.getId());
		product.setPrice(dto.getPrice());
		product.setName(dto.getName());
		Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow();
		product.setCategory(category);
		productRepository.save(product);
	}

	@Override
	public void delete(int id) {
		Product product = productRepository.findById(id).orElseThrow();
		productRepository.delete(product);
	}

	@Override
	public List<ProductForListingDto> getAll() {
		List<Product> productList = productRepository.findAll();
		List<ProductForListingDto> productDtoList = new ArrayList<ProductForListingDto>();
		for (Product product : productList) {
			ProductForListingDto dto = new ProductForListingDto();
			dto.setName(product.getName());
			dto.setPrice(product.getPrice());
			productDtoList.add(dto);
		}
		return productDtoList;
	}

	@Override
	public ProductForListingDto getById(int id) {
		ProductForListingDto dto = new ProductForListingDto();
		Product product = productRepository.findById(id).orElseThrow();
		dto.setName(product.getName());
		dto.setPrice(product.getPrice());
		return dto;
	}
	
}
