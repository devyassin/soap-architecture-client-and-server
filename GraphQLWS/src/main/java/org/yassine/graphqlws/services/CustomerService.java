package org.yassine.graphqlws.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.yassine.graphqlws.dtos.CustomerDto;
import org.yassine.graphqlws.entities.Customer;
import org.yassine.graphqlws.repositeries.CustomerRepositerie;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepositerie customerRepository;

    // Fetch all customers
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // Get a customer by ID
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    // Add a new customer
    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer=Customer.builder()
                .email(customerDto.email())
                .firstName(customerDto.firstName())
                .lastName(customerDto.lastName())
                .phoneNumber(customerDto.phoneNumber())
                .address(customerDto.address())
                .build();
        return customerRepository.save(customer);
    }

    // Update an existing customer
    public Customer updateCustomer(Long id, CustomerDto customerDetails) {
        return customerRepository.findById(id).map(customer -> {
            customer.setFirstName(customerDetails.firstName());
            customer.setLastName(customerDetails.lastName());
            customer.setEmail(customerDetails.email());
            customer.setPhoneNumber(customerDetails.phoneNumber());
            customer.setAddress(customerDetails.address());
            return customerRepository.save(customer);
        }).orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    // Delete a customer by ID
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}