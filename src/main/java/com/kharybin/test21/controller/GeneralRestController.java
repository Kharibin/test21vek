package com.kharybin.test21.controller;


import com.kharybin.test21.model.Goods;
import com.kharybin.test21.model.Order;
import com.kharybin.test21.model.OrderLine;
import com.kharybin.test21.service.Service;
import com.kharybin.test21.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class GeneralRestController {

    private Service<Order> orderService;

    private Service<Goods> goodsService;

    private Service<OrderLine> orderLineService;

    @Autowired
    public GeneralRestController(Service<Order> orderService, Service<Goods> goodsService, Service<OrderLine> orderLineService) {
        this.orderService = orderService;
        this.goodsService = goodsService;
        this.orderLineService = orderLineService;
    }

    public Service<Order> getOrderService() {
        return orderService;
    }

    public void setOrderService(ServiceImpl<Order> orderService) {
        this.orderService = orderService;
    }

    public Service<Goods> getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(Service<Goods> goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/allOrderLines")
    public List<OrderLine> allOrderLines() {
        return orderLineService.getAll();
    }

    @RequestMapping("/orderLineById/")
    public List<OrderLine> orderLineById(Model model, @RequestParam("searchID") Long id) {
        return orderLineService.getById(id);
    }

    @RequestMapping(value = "/addOrderLine", method = GET)
    public String showNewOrderLineForm(Model model) {
        model.addAttribute("allOrders", orderService.getAll());
        model.addAttribute("allGoods", goodsService.getAll());
        return "addOrderLine";
    }

    @RequestMapping(value = "/addOrderLine", method = POST)
    public String processNewOrderLine(OrderLine orderLine) {
        orderLineService.add(orderLine);
        return "redirect:/allOrderLines/";
    }

    @RequestMapping(value = "/editOrderLine/{id}", method = GET)
    public String editOrderLine(@PathVariable Long id, Model model) {
        model.addAttribute("orderLine", orderLineService.getById(id));
        model.addAttribute("allOrders", orderService.getAll());
        model.addAttribute("allGoods", goodsService.getAll());
        return "editOrderLine";
    }

    @RequestMapping(value = "/editOrderLine/{id}", method = POST)
    public String processEditOrder(OrderLine orderLine, @PathVariable Long id) {
        orderLineService.edit(id, orderLine);
        return "redirect:/allOrderLines/";
    }


    @RequestMapping(value = "/deleteOrderLine/{id}", method = GET)
    public String deleteOrderLine(@PathVariable Long id) {
        orderLineService.delete(id);
        return "redirect:/allOrderLines/";
    }

    @CrossOrigin
    @RequestMapping("/allGoods")
    public List<Goods> allGoods() {
        System.out.println("/allGoods link requested");
        return goodsService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/addGoods", method = POST)
    public Goods processNewGoods(@RequestBody Goods goods) {
        goodsService.add(goods);
        System.out.println("/addGoods link requested");
        System.out.println(goods.getName() + " " + goods.getPrice());
        return goods;
    }

    @CrossOrigin
    @RequestMapping(value = "/deleteGoods", method = POST)
    public Goods deleteGoods(@RequestBody Goods goods) {
        System.out.println(goods.getName());
        goodsService.delete(goods.getId());
        System.out.println("/deleteGoods link requested");
        System.out.println(goods.getName() + " " + goods.getPrice());
        return goods;
    }

    @CrossOrigin
    @RequestMapping(value = "/updateGoods", method = POST)
    public Goods updateGoods(@RequestBody Goods goods) {
        goodsService.edit(goods.getId(), goods);
        System.out.println("/updateGoods link requested");
        System.out.println(goods.getName() + " " + goods.getPrice());
        return goods;
    }


}
