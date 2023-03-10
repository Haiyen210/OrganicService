package com.project.organic.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.project.organic.model.Order;
import com.project.organic.model.OrderDetail;

public interface OrderDetailRespository extends JpaRepository<OrderDetail, Integer> {
	OrderDetail findById(int id);
	@Modifying
	@Query("DELETE FROM OrderDetail od where od.orderId.id = ?1")
	void deleteByOrderId(int Id);
}
