package com.kharybin.test21.service;

import com.kharybin.test21.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GoServiceImpl extends ServiceImpl<Goods> {
    public GoServiceImpl(JpaRepository<Goods, Long> repository) {
        super(repository);
    }
}
