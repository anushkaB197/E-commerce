package com.example.kafka.order;

import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class Product {

    private Integer productId;
    private String name;
    private String description;
    private BigDecimal price;
    private double quantity;

    // Constructors
    public Product() {}

    public Product(Integer productId, String name, String description, BigDecimal price, double quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

   public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
