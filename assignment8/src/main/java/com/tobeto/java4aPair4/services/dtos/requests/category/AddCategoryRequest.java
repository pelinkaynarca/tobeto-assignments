package com.tobeto.java4aPair4.services.dtos.requests.category;

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
public class AddCategoryRequest {
	
	@NotBlank(message = "İsim alanı boş olamaz.")
	@Size(min=2, max=50, message = "İsim alanı 2 ile 50 karakter arasında olmalıdır.")
	@NotNull
	private String name;
}
