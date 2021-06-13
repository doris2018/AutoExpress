package com.example.backEnd.handler.controller;

import com.example.backEnd.entity.ShippingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackingController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
    public ResponseEntity<Object> getShippingOrderById(@RequestParam(value = "orderId") int orderId) {
        ShippingOrder shippingOrder = orderService.getShippingOrderById(orderId);
        TrackingResponseBody trackingResponse = new TrackingResponseBody();
        trackingResponse.setOrderId(orderId);
        trackingResponse.setSenderAddress(shippingOrder.getSenderAddress());
        trackingResponse.setReceiverAddress(shippingOrder.getReceiverAddress());
        trackingResponse.setReceiverName(shippingOrder.getReceiverName());
        trackingResponse.setCardNumber(shippingOrder.getCardNumber());
        trackingResponse.setSize(shippingOrder.getSize());
        trackingResponse.setWeight(shippingOrder.getWeight());
        trackingResponse.setDescription(shippingOrder.getDescription());
        trackingResponse.setDeliveryMethod(shippingOrder.getDeliveryMethod());
        trackingResponse.setFee(shippingOrder.getFee());
        trackingResponse.setStatus(shippingOrder.getStatus());
        trackingResponse.setTime(shippingOrder.getTime());
        trackingResponse.setStationId(shippingOrder.getStation().getStationId());
        return new ResponseEntity<>(trackingResponse, HttpStatus.OK);
    }
}
