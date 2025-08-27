package com.example.orderline;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService {

    private final OrderLineRepository repository;
    private final OrderLineMapper mapper;

    public OrderLineService(OrderLineRepository repository, OrderLineMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Integer saveOrderLine(OrderLineRequest request) {
        var order = mapper.toOrderLine(request);
        return repository.save(order).getId(); // Ensure OrderLine has getId()
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderLineResponse)
                .toList();
    }
}
