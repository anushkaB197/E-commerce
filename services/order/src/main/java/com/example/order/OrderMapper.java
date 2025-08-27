package com.example.order;

import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequest request) {
        if (request == null) {
            return null;
        }

        Order order = new Order();
        order.setId(request.id());
        order.setReference(request.reference());
        order.setPaymentMethod(request.paymentMethod());
        order.setCustomerId(request.customerId());

        return order;
    }

    public OrderResponse fromOrder(Order order) {
        return new OrderResponse(
            order.getId(),
            order.getReference(),
            order.getTotalAmount(),
            order.getPaymentMethod(),
            order.getCustomerId()
        );
    }
}
