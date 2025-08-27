package com.example.customer;


import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.example.exception.CustomerNotFoundException;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    // Constructor to replace @RequiredArgsConstructor
    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public String createCustomer(CustomerRequest request) {
        Customer customer = this.repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        Customer customer = this.repository.findById(request.id())
            .orElseThrow(() -> new CustomerNotFoundException(
                String.format("Cannot update customer:: No customer found with the provided ID: %s", request.id())
            ));
        mergeCustomer(customer, request);
        this.repository.save(customer);
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return this.repository.findAll()
            .stream()
            .map(this.mapper::fromCustomer)
            .toList();
    }

    public CustomerResponse findById(String id) {
        return this.repository.findById(id)
            .map(mapper::fromCustomer)
            .orElseThrow(() -> new CustomerNotFoundException(
                String.format("No customer found with the provided ID: %s", id)
            ));
    }

    public boolean existsById(String id) {
        return this.repository.findById(id).isPresent();
    }

    public void deleteCustomer(String id) {
        this.repository.deleteById(id);
    }
}
