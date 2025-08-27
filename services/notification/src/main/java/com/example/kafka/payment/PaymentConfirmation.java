package com.example.kafka.payment;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.math.BigDecimal;

@Embeddable
public class PaymentConfirmation {

    private String orderReference;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    private String customerFirstname;
    private String customerLastname;
    private String customerEmail;

    // Constructors
    public PaymentConfirmation() {}

    public PaymentConfirmation(String orderReference, BigDecimal amount,
                               PaymentMethod paymentMethod, String customerFirstname,
                               String customerLastname, String customerEmail) {
        this.orderReference = orderReference;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCustomerFirstname() {
        return customerFirstname;
    }

    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    public String getCustomerLastname() {
        return customerLastname;
    }

    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}
