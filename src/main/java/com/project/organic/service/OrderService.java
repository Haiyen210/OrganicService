package com.project.organic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.organic.model.Order;
import com.project.organic.respository.OrderRespository;


@Service
@Transactional
public class OrderService {
    private final OrderRespository  orderRespository;

    @Autowired
    public OrderService(OrderRespository orderRespository) {
        this.orderRespository = orderRespository;
    }
    public List<Order> findAllOrders() {
        return orderRespository.findAll();
    }

    public Order updateOrder(Order order) {
        return orderRespository.save(order);
    }
    public void deleteOrder(int id){
    		orderRespository.deleteById(id);
    }
    public Order addOrder(Order order) {
        return orderRespository.save(order);
    }
    public Order findOrderByID(int id){
        return orderRespository.findById(id);
    }

}
