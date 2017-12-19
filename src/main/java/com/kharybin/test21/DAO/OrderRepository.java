package com.kharybin.test21.DAO;

import com.kharybin.test21.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface OrderRepository extends GeneralRepository<Order> {
}
