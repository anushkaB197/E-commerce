package com.example.kafka.order;

import com.example.kafka.payment.PaymentMethod;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Embeddable
public class OrderConfirmation {

    private String orderReference;

    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Embedded
    private Customer customer;

    @ElementCollection
    private List<Product> products;

    // Constructors
    public OrderConfirmation() {}

    public OrderConfirmation(String orderReference, BigDecimal totalAmount,
                             PaymentMethod paymentMethod, Customer customer,
                             List<Product> products) {
        this.orderReference = orderReference;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.customer = customer;
        this.products = products;
    }

    // Getters and Setters
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
