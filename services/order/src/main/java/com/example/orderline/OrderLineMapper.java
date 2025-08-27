package com.example.orderline;

import com.example.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        if (request == null) {
            return null;
        }

        OrderLine orderLine = new OrderLine();
        orderLine.setProductId(request.productId());

        // Convert double to Integer safely
        orderLine.setQuantity((int) request.quantity());

        Order order = new Order();
        order.setId(request.orderId());
        orderLine.setOrder(order);

        return orderLine;
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        if (orderLine == null) {
            return null;
        }

        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }
}
