package com.kharybin.test21.controller;

import com.kharybin.test21.Test21Application;
import com.kharybin.test21.model.Goods;
import com.kharybin.test21.model.Order;
import com.kharybin.test21.model.OrderLine;
import com.kharybin.test21.service.Service;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class GeneralControllerTest {

    @Mock
    Service<Order> orderServiceMock;

    @Mock
    Service<Goods> goodsServiceMock;

    @Mock
    Service<OrderLine> orderLineServiceMock;

    @InjectMocks
    GeneralController generalControllerTest;

    static MockMvc mockMvc;
    @BeforeClass
    public static void setupTest() {
        mockMvc = standaloneSetup(new Test21Application()).build();
    }

    @Test
    public void homeTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void allOrderLines() {
    }

    @Test
    public void allOrders() {
    }

    @Test
    public void allGoods() {
    }

    @Test
    public void orderLineById() {
    }

    @Test
    public void orderById() {
    }

    @Test
    public void goodsById() {
    }

    @Test
    public void showNewOrderLineForm() {
    }

    @Test
    public void processNewOrderLine() {
    }

    @Test
    public void showNewOrderForm() {
    }

    @Test
    public void processNewOrder() {
    }

    @Test
    public void showNewGoodsForm() {
    }

    @Test
    public void processNewGoods() {
    }

    @Test
    public void editOrderLine() {
    }

    @Test
    public void processEditOrder() {
    }

    @Test
    public void editOrder() {
    }

    @Test
    public void processEditOrder1() {
    }

    @Test
    public void editGoods() {
    }

    @Test
    public void processEditGoods() {
    }

    @Test
    public void deleteOrderLine() {
    }

    @Test
    public void deleteOrder() {
    }

    @Test
    public void deleteGoods() {
    }
}