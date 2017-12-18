package com.kharybin.test21;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/orderById/{id}")
    public String orderById(Model model, @PathVariable Long id) {
        List<Order> orders = new ArrayList<>();
        Order order = null;
        try {
            order = orderRepository.getOne(id);
        } catch (Exception e) {
            System.out.println("NO SUCH ORDER!");
            return "noSuchOrder";
        }

        if (order != null) orders.add(order);
        if (!orders.isEmpty())
            model.addAttribute("allOrders", orders);
        return "redirect:/allOrders/";
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
