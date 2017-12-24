package com.kharybin.test21.service;

import com.kharybin.test21.model.Order;
import com.kharybin.test21.model.OrderLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrLineServiseImpl extends ServiceImpl<OrderLine> {

    @Autowired
    public OrLineServiseImpl(JpaRepository<OrderLine, Long> repository) {
        super(repository);
    }

    public void OrLineAdd(Long orderId, Long goodsId, Long count){
        OrderLine orderLine = new OrderLine();
        orderLine.setOrderId(orderId);
        orderLine.setGoodsId(goodsId);
        orderLine.setCount(count);
        getRepository().save(orderLine);
    }


}
