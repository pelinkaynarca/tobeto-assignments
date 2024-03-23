package com.tobeto.java4aPair4.entities;
import jakarta.persistence.*;

@Table(name="cart_items")
@Entity
public class CartItem {
	
	public CartItem() {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name="quantity")
    private int quantity;

    public CartItem(int id, int quantity, double price, Cart cart, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.cart = cart;
		this.product = product;
	}

	@Column(name="price")
    private double price;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
}
