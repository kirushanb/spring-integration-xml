package com.techsera.assignment.service;

import com.techsera.assignment.constant.CustomerStatus;
import com.techsera.assignment.entity.Customer;
import com.techsera.assignment.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


public class IntegrationService {
    private static final Logger log = LoggerFactory.getLogger(IntegrationService.class);

    private CustomerRepository customerRepository;

    @Value("${public.api}")
    private String url;

    public IntegrationService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    private Message<Customer> customMessage(Customer customer,String action){
        Message<Customer> newMessage=MessageBuilder.withPayload(customer).setHeader("test",action).build();

        return newMessage;
    }


    public Message<Customer> receiveMessage(Message<Customer> message) throws MessagingException{
        Optional<Customer> customer=customerRepository.findByNameAndPassword(message.getPayload().getName(),message.getPayload().getPassword());
        if(customer.isPresent()){
            if(customer.get().getCustomerStatus()== CustomerStatus.ACTIVE){
                return customMessage(customer.get(),"success");
            }
            return customMessage(customer.get(),"fail");
        }

        return customMessage(new Customer(message.getPayload().getName(),null,CustomerStatus.INACTIVE),"fail");
    }



    public void sendCall(Message<Customer> message) {

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, new HttpEntity(message.getPayload(), new HttpHeaders()),String.class);
        log.info(response.toString());
    }


    public void logFailed(Message<Customer> message) {

        log.info(message.getPayload().toString());
    }



}
