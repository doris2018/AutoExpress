package com.example.backEnd.handler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DispatchService dispatchService;

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<Object> placeOrder(@RequstBody OrderRequestBody orderRequest) {

        //request containing the request body
        OrderResponseBody orderResponse = new OrderResponseBody();
        int orderId = orderService.addOrder(orderRequest);
        orderResponse.setOrderId(orderId);

        //add a dispatched stationId to the response
        TrackingResponseBody trackingResponseBody = new TrackingResponseBody();
        int stationId = dispatchService.dispatchStation(orderRequest);
        trackingResponseBody.setStationid(stationId);

        if (orderResponse == null) {
            // give a response body class object in the first parameter
            return new ResponseEntity<>(null, httpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public ResponseEntity<Object> getCurrentUserOrders() {
        List<OrderInfoResponseBody> orderList = orderService.getCurrentUserOrders();
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }
}
