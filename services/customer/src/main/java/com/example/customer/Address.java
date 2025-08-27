package com.example.customer;


import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Embeddable;

@Validated
@Embeddable
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;

    // No-argument constructor
    public Address() {
    }

    // All-argument constructor
    public Address(String street, String houseNumber, String zipCode) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.zipCode = zipCode;
    }

    // Getters and Setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
