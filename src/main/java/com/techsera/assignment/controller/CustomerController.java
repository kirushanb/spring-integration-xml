package com.techsera.assignment.controller;

import com.techsera.assignment.entity.Customer;
import com.techsera.assignment.service.IntegrationGateway;


import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/integrate")
public class CustomerController {



    private final IntegrationGateway integrationGateway;

    public CustomerController(IntegrationGateway integrationGateway) {
        this.integrationGateway = integrationGateway;
    }

    @PostMapping
    public void search(@RequestBody Customer customer){
        integrationGateway.process(customer);
    }
}
