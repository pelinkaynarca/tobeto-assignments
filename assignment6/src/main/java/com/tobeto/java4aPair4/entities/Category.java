package com.tobeto.java4aPair4.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name="categories")
@Entity
public class Category {
	
	public Category() {
	}

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getModified_at() {
		return modified_at;
	}

	public void setModified_at(LocalDateTime modified_at) {
		this.modified_at = modified_at;
	}

	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}

	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category(int id, String name, LocalDateTime created_at, LocalDateTime modified_at, LocalDateTime deleted_at,
			List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.created_at = created_at;
		this.modified_at = modified_at;
		this.deleted_at = deleted_at;
		this.products = products;
	}

	@Column(name="name")
    private String name;

    @Column(name="created_at")
    private LocalDateTime created_at;

    @Column(name="modified_at")
    private LocalDateTime modified_at;

    @Column(name="deleted_at")
    private LocalDateTime deleted_at;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private List<Product> products;
}
