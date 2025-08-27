package com.example.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class ProductRequest {

    private Integer id;

    @NotNull(message = "Product name is required")
    private String name;

    @NotNull(message = "Product description is required")
    private String description;

    @Positive(message = "Available quantity should be positive")
    private double availableQuantity;

    @Positive(message = "Price should be positive")
    private BigDecimal price;

    @NotNull(message = "Product category is required")
    private Integer categoryId;

    // Constructors
    public ProductRequest() {}

    public ProductRequest(Integer id, String name, String description, double availableQuantity, BigDecimal price, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.categoryId = categoryId;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvailableQuantity() {
        return availableQuantity;
    }

    public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public void setAvailableQuantity(double availableQuantity) {
    
    }
}