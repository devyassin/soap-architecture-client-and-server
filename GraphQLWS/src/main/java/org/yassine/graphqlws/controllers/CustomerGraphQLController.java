package org.yassine.graphqlws.controllers;


import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.yassine.graphqlws.dtos.CustomerDto;
import org.yassine.graphqlws.entities.Customer;
import org.yassine.graphqlws.services.CustomerService;

import java.util.List;

@Controller
@AllArgsConstructor
@CrossOrigin("*")
public class CustomerGraphQLController {
    private final CustomerService customerService;


    @QueryMapping
    public List<Customer> customersList(){
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public Customer customerById(@Argument Long id){
        return customerService.getCustomerById(id).orElseThrow(()->new RuntimeException("Customer not found"));
    }

    @MutationMapping
    public Customer createCustomer(@Argument CustomerDto customer){
        return customerService.addCustomer(customer);
    }

    @MutationMapping
    public Customer updateCustomer(@Argument Long id,@Argument CustomerDto customer){
        return customerService.updateCustomer(id,customer);
    }

    @MutationMapping
    public void deleteCustomer(@Argument Long id){
         customerService.deleteCustomer(id);
    }
}
