package com.project.organic.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.organic.model.Order;
import com.project.organic.model.OrderDetail;
import com.project.organic.respository.OrderDetailRespository;


@Service
@Transactional
public class OrderDetailService {
    private final OrderDetailRespository  orderDetailRespository;

    @Autowired
    public OrderDetailService(OrderDetailRespository orderDetailRespository) {
        this.orderDetailRespository = orderDetailRespository;
    }
    public List<OrderDetail> findAllOrderDetails() {
        return orderDetailRespository.findAll();
    }

    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRespository.save(orderDetail);
    }
    public void deleteOrderDetail(int id){
    		orderDetailRespository.deleteById(id);
    }
    public void deleteAllDetail(int id){
		orderDetailRespository.deleteByOrderId(id);
}
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        return orderDetailRespository.save(orderDetail);
    }
    public OrderDetail findOrderDetailByID(int id){
        return orderDetailRespository.findById(id);
    }
}
