package com.example.kafka;

import com.example.email.EmailService;
import com.example.kafka.order.OrderConfirmation;
import com.example.kafka.payment.PaymentConfirmation;
import com.example.notification.Notification;
import com.example.notification.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.example.notification.NotificationType.ORDER_CONFIRMATION;
import static com.example.notification.NotificationType.PAYMENT_CONFIRMATION;
import static java.lang.String.format;

@Service
public class NotificationsConsumer {

    private final NotificationRepository repository;
    private final EmailService emailService;

    public NotificationsConsumer(NotificationRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotifications(PaymentConfirmation paymentConfirmation) {
        System.out.println(format("Consuming the message from payment-topic Topic:: %s", paymentConfirmation));
        Notification notification = new Notification();
        notification.setType(PAYMENT_CONFIRMATION);
        notification.setNotificationDate(LocalDateTime.now());
        notification.setPaymentConfirmation(paymentConfirmation);
        repository.save(notification);
        var customerName = paymentConfirmation.getCustomerFirstname() + " " + paymentConfirmation.getCustomerLastname();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.getCustomerEmail(),
                customerName,
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotifications(OrderConfirmation orderConfirmation) {
        System.out.println(format("Consuming the message from order-topic Topic:: %s", orderConfirmation));
        Notification notification = new Notification();
        notification.setType(ORDER_CONFIRMATION);
        notification.setNotificationDate(LocalDateTime.now());
        notification.setOrderConfirmation(orderConfirmation);
        repository.save(notification);

        var customerName = orderConfirmation.getCustomer().getFirstname() + " " + orderConfirmation.getCustomer().getLastname();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.getCustomer().getEmail(),
                customerName,
                orderConfirmation.getTotalAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );
    }

}
