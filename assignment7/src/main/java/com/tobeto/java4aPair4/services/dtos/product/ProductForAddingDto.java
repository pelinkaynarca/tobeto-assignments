package com.tobeto.java4aPair4.services.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForAddingDto {
	private int categoryId;
	private String name;
	private double price;
}
