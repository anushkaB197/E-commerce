package com.example.payment;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService service;

    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> createPayment(@RequestBody @Valid PaymentRequest request) {
        return ResponseEntity.ok(this.service.createPayment(request));
    }
}
