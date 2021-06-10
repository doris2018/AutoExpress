package com.example.backEnd.dao;

import com.example.backEnd.entity.Authorities;
import com.example.backEnd.entity.Customer;
import com.example.backEnd.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Respository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public int addCustomer(RegisterRequestBody request) { // set是否成功，通过返回一个int来表达
        User user = new User(); // build a user from request
        user.setEnabled(true);
        user.setEmailId(request.getEmail());
        user.setPassword(request.getPassword());

        Customer customer = new Customer(); // build a customer from request
        customer.setBillingAddress(request.getBillingAddress());
        customer.setShippingAddress(request.getShippingAddress());
        customer.setFirstName(request.getFristName());
        customer.setLastName(request.getLastName());
        customer.setUser(user);

        Authorities authorities = new Authorities(); // build authorities from request
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmailId(request.getEmail());
        Session session = null;

    }
}
