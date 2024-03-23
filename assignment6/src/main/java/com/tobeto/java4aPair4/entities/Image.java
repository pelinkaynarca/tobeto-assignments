package com.tobeto.java4aPair4.entities;

import jakarta.persistence.*;
import java.util.List;

@Table(name="images")
@Entity
public class Image {
	
	public Image() {
	}

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Image(int id, String image_url, Product product) {
		super();
		this.id = id;
		this.image_url = image_url;
		this.product = product;
	}

	@Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image_url")
    private String image_url;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

}
