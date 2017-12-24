package com.kharybin.test21.controller;


import com.kharybin.test21.model.Goods;
import com.kharybin.test21.model.Order;
import com.kharybin.test21.model.OrderLine;
import com.kharybin.test21.service.Service;
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

    private Service<Order> orderService;

    private Service<Goods> goodsService;

    private Service<OrderLine> orderLineService;

    @Autowired
    public GeneralController(Service<Order> orderService, Service<Goods> goodsService, Service<OrderLine> orderLineService) {
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

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/allOrderLines")
    public String allOrderLines(Model model) {
        model.addAttribute("allOrderLines", orderLineService.getAll());
        model.addAttribute("orderService", orderService);
        model.addAttribute("goodsService", goodsService);
        return "AllOrderLines";
    }

    @RequestMapping("/allOrders")
    public String allOrders(Model model) {
        model.addAttribute("allOrders", orderService.getAll());
        return "allOrders";
    }

    @RequestMapping("/allGoods")
    public String allGoods(Model model) {
        model.addAttribute("allGoods", goodsService.getAll());
        return "allGoods";
    }

    @RequestMapping("/orderLineById/")
    public String orderLineById(Model model, @RequestParam("searchID") Long id) {
        if (!orderLineService.getById(id).isEmpty()) {
            model.addAttribute("allOrderLines", orderLineService.getById(id));
            return "allOrderLines";
        } else return "/noSuchOrderLine";
    }

    @RequestMapping("/orderById/")
    public String orderById(Model model, @RequestParam("searchID") Long id) {
        if (!orderService.getById(id).isEmpty()) {
            model.addAttribute("allOrders", orderService.getById(id));
            return "allOrders";
        } else return "/noSuchOrder";
    }

    @RequestMapping("/goodsById/")
    public String goodsById(Model model, @RequestParam("searchID") Long id) {
        if (!goodsService.getById(id).isEmpty()) {
            model.addAttribute("allGoods", goodsService.getById(id));
            return "allGoods";
        } else return "/noSuchGoods";
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

    @RequestMapping(value = "/addOrder", method = GET)
    public String showNewOrderForm() {
        return "addOrder";
    }

    @RequestMapping(value = "/addOrder", method = POST)
    public String processNewOrder(Order order) {
        orderService.add(order);
        return "redirect:/allOrders/";
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

    @RequestMapping(value = "/editOrderLine/{id}", method = GET)
    public String editOrderLine(@PathVariable Long id, Model model) {
        model.addAttribute("orderLine", orderLineService.getById(id));
        return "editOrderLine";
    }

    @RequestMapping(value = "/editOrderLine/{id}", method = POST)
    public String processEditOrder(OrderLine orderLine, @PathVariable Long id) {
        orderLineService.edit(id, orderLine);
        return "redirect:/allOrderLines/";
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

    @RequestMapping(value = "/deleteOrderLine/{id}", method = GET)
    public String deleteOrderLine(@PathVariable Long id) {
        orderLineService.delete(id);
        return "redirect:/allOrderLines/";
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = GET)
    public String deleteOrder(@PathVariable Long id) {
        orderService.delete(id);
        return "redirect:/allOrders/";
    }

    @RequestMapping(value = "/deleteGoods/{id}", method = GET)
    public String deleteGoods(@PathVariable Long id) {
        goodsService.delete(id);
        return "redirect:/allGoods/";
    }


}
