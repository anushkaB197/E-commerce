package com.example.customer;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Customer {

  @Id
  private String id;
  private String firstname;
  private String lastname;
  private String email;
  @Embedded
  private Address address;
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFirstname() {
	return firstname;
}
public void setFirstname(String firstname) {
	this.firstname = firstname;
}
public String getLastname() {
	return lastname;
}
public void setLastname(String lastname) {
	this.lastname = lastname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public Customer(String email, String firstname, String lastname, Address address, String id) {
	super();
	this.email = email;
	this.firstname = firstname;
	this.lastname = lastname;
	this.address = address;
	this.id = id;
}
public Customer() {
	super();
}
  
  
}
