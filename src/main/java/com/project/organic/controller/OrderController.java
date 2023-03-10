package com.project.organic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.organic.model.Order;
import com.project.organic.respository.OrderRespository;
import com.project.organic.service.OrderService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    OrderRespository orderRespository;
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllorders() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") int id) {
    	Order Order = orderService.findOrderByID(id);
        return new ResponseEntity<>(Order, HttpStatus.OK);
    }
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
    	Order newOrder = orderService.addOrder(order);	
    	System.out.println(order);
    	System.out.println(newOrder);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }
    @PutMapping("/orders/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
    	Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") int id) {
        if (orderService.findOrderByID(id)!=null){
        	orderService.deleteOrder(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
