package com.techsera.assignment;

import com.techsera.assignment.constant.CustomerStatus;
import com.techsera.assignment.entity.Customer;
import com.techsera.assignment.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ImportResource("classpath:Beans.xml")
public class SpringIntegrationAssignmentApplication {

    private CustomerRepository customerRepository;

    public SpringIntegrationAssignmentApplication(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationAssignmentApplication.class, args);

    }


    public void setCustomer(){
        List<Customer> customerList=new ArrayList<>();
        customerList.add(new Customer("Lewis","lewis", CustomerStatus.ACTIVE));
        customerList.add(new Customer("Max","max", CustomerStatus.INACTIVE));
        customerRepository.saveAll(customerList);


    }
}
