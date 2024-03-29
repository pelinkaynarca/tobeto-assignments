package com.tobeto.java4aPair4.services.dtos.requests.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductRequest {
	
	@Min(value = 0, message = "categoryId 0'dan küçük olamaz.")
	private int categoryId;
	@NotBlank(message = "İsim alanı boş olamaz.")
	@Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
	@NotNull
	private String name;
	@Min(value = 0, message = "Ürün fiyatı 0'dan küçük olamaz.")
	private double price;
}
