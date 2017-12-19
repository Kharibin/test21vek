package com.kharybin.test21.controller;


import com.kharybin.test21.DAO.GoodsRepository;
import com.kharybin.test21.DAO.OrderRepository;
import com.kharybin.test21.model.Goods;
import com.kharybin.test21.model.Order;
import com.kharybin.test21.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class GeneralController {

    private ServiceImpl<Order> orderService;

    private ServiceImpl<Goods> goodsService;

    @Autowired
    public GeneralController(ServiceImpl<Order> orderService, ServiceImpl<Goods> goodsService) {
        this.orderService = orderService;
        this.goodsService = goodsService;
    }

    public ServiceImpl<Order> getOrderService() {
        return orderService;
    }

    public void setOrderService(ServiceImpl<Order> orderService) {
        this.orderService = orderService;
    }

    public ServiceImpl<Goods> getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(ServiceImpl<Goods> goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/allOrders")
    public String allOrders(Model model) {
        model.addAttribute("allOrders", orderService.getAll());
        return "allOrders";
    }

    @RequestMapping("/orderById/")
    public String orderById(Model model, @RequestParam("searchID") Long id) {
        if (!orderService.getById(id).isEmpty()) {
            model.addAttribute("allOrders", orderService.getById(id));
            return "allOrders";
        } else return "/noSuchOrder";
    }

    @RequestMapping(value = "/addOrder", method = GET)
    public String showNewOrderForm() {
        return "addOrder";
    }

    @RequestMapping(value = "/addOrder", method = POST)
    public String processNewOrder(Order order) {
        orderService.add(order);
        return "redirect:/allOrders/";
    }

    @RequestMapping(value = "/editOrder/{id}", method = GET)
    public String editOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.getById(id));
        return "editOrder";
    }

    @RequestMapping(value = "/editOrder/{id}", method = POST)
    public String processEditOrder(Order order, @PathVariable Long id) {
        orderService.edit(id, order);
        return "redirect:/allOrders/";
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = GET)
    public String deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/allOrders/";
    }

    @RequestMapping("/allGoods")
    public String allGoods(Model model) {
        model.addAttribute("allGoods", goodsService.getAll());
        return "allGoods";
    }

    @RequestMapping(value = "/addGoods", method = GET)
    public String showNewGoodsForm() {
        return "addGoods";
    }

    @RequestMapping(value = "/addGoods", method = POST)
    public String processNewGoods(Goods goods) {
        goodsService.add(goods);
        return "redirect:/allGoods/";
    }

    @RequestMapping(value = "/editGoods/{id}", method = GET)
    public String editGoods(@PathVariable Long id, Model model) {
        model.addAttribute("goods", goodsService.getById(id));
        return "editGoods";
    }

    @RequestMapping(value = "/editGoods/{id}", method = POST)
    public String processEditGoods(Goods goods, @PathVariable Long id) {
        goodsService.edit(id, goods);
        return "redirect:/allGoods/";
    }

    @RequestMapping(value = "/deleteGoods/{id}", method = GET)
    public String deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return "redirect:/allGoods/";
    }

    @RequestMapping("/goodsById/")
    public String goodsById(Model model, @RequestParam("searchID") Long id) {
        if (!goodsService.getById(id).isEmpty()) {
            model.addAttribute("allGoods", orderService.getById(id));
            return "allGoods";
        } else return "/noSuchGoods";
    }


}
