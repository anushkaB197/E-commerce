package com.example.email;

import com.example.kafka.order.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.scheduling.annotation.Async;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmailService {

    private static final Logger log = LoggerFactory.getLogger(EmailService.class);

    @Async
    public void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) {
        log.info("Email sending is disabled. Skipping sendPaymentSuccessEmail to {}", destinationEmail);
    }

    @Async
    public void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> products
    ) {
        log.info("Email sending is disabled. Skipping sendOrderConfirmationEmail to {}", destinationEmail);
    }
}
