package com.kharybin.test21.service;

import com.kharybin.test21.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrServiseImpl extends ServiceImpl<Order> {

    @Autowired
    public OrServiseImpl(JpaRepository<Order, Long> repository) {
        super(repository);
    }
}
