package com.example.notification;

import com.example.kafka.order.OrderConfirmation;
import com.example.kafka.payment.PaymentConfirmation;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private LocalDateTime notificationDate;

    @Embedded
    private OrderConfirmation orderConfirmation;

    @Embedded
    private PaymentConfirmation paymentConfirmation;

    // Constructors
    public Notification() {}

    public Notification(NotificationType type, LocalDateTime notificationDate,
                        OrderConfirmation orderConfirmation, PaymentConfirmation paymentConfirmation) {
        this.type = type;
        this.notificationDate = notificationDate;
        this.orderConfirmation = orderConfirmation;
        this.paymentConfirmation = paymentConfirmation;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificationType getType() {
        return type;
    }

    public void setType(NotificationType type) {
        this.type = type;
    }

    public LocalDateTime getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(LocalDateTime notificationDate) {
        this.notificationDate = notificationDate;
    }

    public OrderConfirmation getOrderConfirmation() {
        return orderConfirmation;
    }

    public void setOrderConfirmation(OrderConfirmation orderConfirmation) {
        this.orderConfirmation = orderConfirmation;
    }

    public PaymentConfirmation getPaymentConfirmation() {
        return paymentConfirmation;
    }

    public void setPaymentConfirmation(PaymentConfirmation paymentConfirmation) {
        this.paymentConfirmation = paymentConfirmation;
    }
}
