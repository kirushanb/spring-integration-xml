package com.techsera.assignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techsera.assignment.constant.CustomerStatus;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @JsonProperty( value = "password", access = JsonProperty.Access.WRITE_ONLY)
    @Column
    private String password;

    @Column
    private CustomerStatus customerStatus;

    public Customer() {
    }

    public Customer(String name, String password, CustomerStatus customerStatus) {
        this.name=name;
        this.password=password;
        this.customerStatus=customerStatus;
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", customerStatus=" + customerStatus +
                '}';
    }
}
