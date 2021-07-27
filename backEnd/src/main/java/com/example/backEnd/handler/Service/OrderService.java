package com.example.backEnd.handler.Service;
import com.example.backEnd.handler.dao.OrderDao;
import com.example.backEnd.entity.ShippingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;
    public int addOrder(OrderRequestBody orderRequest) {
        return orderDao.addOrder(orderRequest);
    }
    public ShippingOrder getShippingOrderById(int orderId) {
        return orderDao.getShippingOrderById(orderId);
    }

    public List<OrderInfoResponseBody> getCurrentUserOrders() {
        return orderDao.getCurrentUserOrders();
    }
}
