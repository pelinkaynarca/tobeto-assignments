package com.tobeto.java4aPair4.services.dtos.requests.category;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
	@Min(value = 0, message = "Ürün Id'si 0'dan küçük olamaz.")
	private int id;
	@NotBlank(message = "İsim alanı boş olamaz.")
	@Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
	@NotNull
	private String name;
}
