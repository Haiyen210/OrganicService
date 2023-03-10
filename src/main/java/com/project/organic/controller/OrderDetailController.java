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
import com.project.organic.model.OrderDetail;
import com.project.organic.respository.OrderDetailRespository;
import com.project.organic.service.OrderDetailService;
import com.project.organic.service.SendEmailService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrderDetailController {
    @Autowired
    OrderDetailRespository orderDetailRespository;
    @Autowired
	private SendEmailService notificationService;
    private final OrderDetailService orderDetailService;


    public OrderDetailController(OrderDetailService orderDetailService) {
        this.orderDetailService = orderDetailService;
    }

    @GetMapping("/orderDetails")
    public ResponseEntity<List<OrderDetail>> getAllorders() {
        List<OrderDetail> orders = orderDetailService.findAllOrderDetails();
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    @GetMapping("/orderDetails/{id}")
    public ResponseEntity<OrderDetail> getOrderById(@PathVariable("id") int id) {
    	OrderDetail orderDetail = orderDetailService.findOrderDetailByID(id);
        return new ResponseEntity<>(orderDetail, HttpStatus.OK);
    }
    @PostMapping("/orderDetails")
    public ResponseEntity<OrderDetail> createOrder(@RequestBody List<OrderDetail> orderDetail) {
    	for (OrderDetail orderDetail2 : orderDetail) {
			OrderDetail newOrder = orderDetailService.addOrderDetail(orderDetail2);
		}
    	//gửi mail
    	notificationService.sendEmailOrder(orderDetail);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/orderDetails/update")
    public ResponseEntity<OrderDetail> updateOrderDetail(@RequestBody OrderDetail orderDetail) {
    	OrderDetail updateOrder = orderDetailService.updateOrderDetail(orderDetail);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }
    @DeleteMapping("/orderDetails/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable("id") int id) {
        if (orderDetailService.findOrderDetailByID(id)!=null){
        	orderDetailService.deleteOrderDetail(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/orderId/{id}")
    public ResponseEntity<?> deleteAllDetail(@PathVariable("id") int id) {
       
        	orderDetailService.deleteAllDetail(id);
            return new ResponseEntity<>(HttpStatus.OK);
    
        
    }


}
