package com.example.order;

import com.example.orderline.OrderLine;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "customer_order")
public class Order {

	@Id
	@GeneratedValue
	private Integer id;

	@Column(unique = true, nullable = false)
	private String reference;

	private BigDecimal totalAmount;

	@Enumerated(EnumType.STRING)
	private PaymentMethod paymentMethod;

	private String customerId;

	@OneToMany(mappedBy = "order")
	private List<OrderLine> orderLines;

	@CreatedDate
	@Column(updatable = false, nullable = false)
	private LocalDateTime createdDate;

	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime lastModifiedDate;

	public Order() {
	}

	public Order(Integer id, String reference, BigDecimal totalAmount, PaymentMethod paymentMethod, String customerId,
			List<OrderLine> orderLines, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
		this.id = id;
		this.reference = reference;
		this.totalAmount = totalAmount;
		this.paymentMethod = paymentMethod;
		this.customerId = customerId;
		this.orderLines = orderLines;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}

	// Getters and setters...

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
