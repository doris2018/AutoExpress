package com.example.backEnd.handler.Service;

// service layer:
// to decouple controller and DAO
// if you have some entity related logic like fetch an image or use external service, you need to put them here

import com.example.backEnd.handler.dao.CustomerDao;
import com.example.backEnd.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public int addCustomer(RegisterRequestBody request) {
        return customerDao.addCustomer(request);
    }

    public Customer getCurrentCustomer() {
        return customerDao.getCurrentCustomer();
    }
}
