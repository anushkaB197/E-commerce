package com.example.orderline;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
public class OrderLineController {

    private final OrderLineService service;

    public OrderLineController(OrderLineService service) {
        this.service = service;
    }

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(
            @PathVariable("order-id") Integer orderId
    ) {
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }
}
