package com.kharybin.test21.controller;


import com.kharybin.test21.DAO.OrderRepository;
import com.kharybin.test21.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/allOrders")
    public String allOrders(Model model) {
        List<Order> orders = orderRepository.findAll();
        if (!orders.isEmpty())
            model.addAttribute("allOrders", orders);
        return "allOrders";
    }

    @RequestMapping("/orderById/")
    public String orderById(Model model, @RequestParam("searchID") Long id) {
        List<Order> orders = new ArrayList<>();
        if (orderRepository.existsById(id)) {
            Order order = orderRepository.getOne(id);
            orders.clear();
            orders.add(order);
            model.addAttribute("allOrders", orders);
            return "allOrders";
        }
        else return "/noSuchOrder";
    }

    @RequestMapping(value = "/addOrder", method = GET)
    public String showNewOrderForm() {
        return "addOrder";
    }

    @RequestMapping(value = "/addOrder", method = POST)
    public String processNewOrder(Order order) {
        orderRepository.save(order);
        return "redirect:/allOrders/";
    }

    @RequestMapping(value = "/editOrder/{orderId}", method = GET)
    public String editOrder(@PathVariable Long orderId, Model model) {
        model.addAttribute("order", orderRepository.getOne(orderId));
        return "editOrder";
    }

    @RequestMapping(value = "/editOrder/{orderId}", method = POST)
    public String processEditOrder(Order order, @PathVariable Long orderId) {
        Order oldOrder = orderRepository.getOne(orderId);
        oldOrder.setAddress(order.getAddress());
        oldOrder.setClient(order.getClient());
        oldOrder.setDate(order.getDate());
        orderRepository.save(oldOrder);
        return "redirect:/allOrders/";
    }

    @RequestMapping(value = "/deleteOrder/{orderId}", method = GET)
    public String deleteOrder(@PathVariable Long orderId) {
        orderRepository.deleteById(orderId);
        return "redirect:/allOrders/";
    }


}
