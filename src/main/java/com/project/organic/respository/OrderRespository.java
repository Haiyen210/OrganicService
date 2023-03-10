package com.project.organic.respository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.organic.model.Order;

public interface OrderRespository extends JpaRepository<Order, Integer> {
	Order findById(int id);
	
}
