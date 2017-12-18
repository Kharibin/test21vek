package com.kharybin.test21.DAO;

import com.kharybin.test21.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
