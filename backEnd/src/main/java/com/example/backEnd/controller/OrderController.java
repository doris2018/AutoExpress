package com.example.backEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DispatchService dispatchService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<Object> placeOrder(@RequstBody OrderRequestBody orderRequest)
}
