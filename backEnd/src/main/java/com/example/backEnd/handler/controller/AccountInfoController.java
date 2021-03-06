package com.example.backEnd.handler.controller;

import com.example.backEnd.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AccountInfoController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/accountinfo", method = RequestMethod.GET)
    public ResponseEntity<Object> accountInfo() {
        System.out.println("Enter the accountInfo controller");
        Customer customer = customerService.getCurrentCustomer():
        AccountInfoResponseBody response = new AccountInfoResponseBody();
        response.setEmail(customer.getUser().getEmailId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setBillingAddress(customer.getBillingAddress());
        response.setShippingAddress(customer.getShippingAddress());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
