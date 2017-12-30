package com.kharybin.test21.controller;

import com.kharybin.test21.Test21Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GeneralControllerTest {

    @Autowired
    MockMvc mockMvc;

    @InjectMocks
    Test21Application test21Application;

    @Test
    public void homeTest() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/home.html"));
    }

    @Test
    public void allOrderLines() throws Exception {
        mockMvc.perform(get("/allOrderLines"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("allOrderLines"
                        , "orderService", "goodsService"));
    }

    @Test
    public void allOrders() throws Exception {
        mockMvc.perform(get("/allOrders"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("allOrders"));
    }

    @Test
    public void allGoods() throws Exception {
        mockMvc.perform(get("/allGoods"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("allGoods"));
        }

    @Test (expected = AssertionError.class)
    public void orderLineByIdFail() throws Exception {
        mockMvc.perform(get("/orderLineById/").param("searchID", String.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("allOrderLines"))
                .andExpect(MockMvcResultMatchers.view().name("allOrderLines.html"));
    }

    @Test
    public void orderLineById() throws Exception {
        mockMvc.perform(get("/orderLineById/").param("searchID", String.valueOf(1)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("/noSuchOrderLine"));
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