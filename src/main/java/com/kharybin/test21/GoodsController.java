package com.kharybin.test21;


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
public class GoodsController {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    public GoodsController(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
    }

    @RequestMapping("/allGoods")
    public String allGoods(Model model) {
        List<Goods> goodsList = goodsRepository.findAll();
        if (!goodsList.isEmpty())
            model.addAttribute("allGoods", goodsList);
        return "allGoods";
    }

    @RequestMapping("/goodsById/{id}")
    public String orderById(Model model, @PathVariable Long id) {
        List<Goods> goodsList = new ArrayList<>();
        Goods goods = null;
        try {
            goods = goodsRepository.getOne(id);
        } catch (Exception e) {
            System.out.println("NO SUCH GOODS!");
            return "noSuchGoods";
        }

        if (goods != null) goodsList.add(goods);
        if (!goodsList.isEmpty())
            model.addAttribute("allGoods", goodsList);
        return "redirect:/allGoods/";
    }

    @RequestMapping(value = "/addGoods", method = GET)
    public String showNewGoodsForm() {
        return "addGoods";
    }

    @RequestMapping(value = "/addGoods", method = POST)
    public String processNewGoods(Goods goods) {
        goodsRepository.save(goods);
        return "redirect:/allGoods/";
    }

    @RequestMapping(value = "/editGoods/{goodsId}", method = GET)
    public String editOrder(@PathVariable Long goodsId, Model model) {
        model.addAttribute("goods", goodsRepository.getOne(goodsId));
        return "editGoods";
    }

    @RequestMapping(value = "/editGoods/{goodsId}", method = POST)
    public String processEditOrder(Goods goods, @PathVariable Long goodsId) {
        Goods oldGoods = goodsRepository.getOne(goodsId);
        oldGoods.setName(goods.getName());
        oldGoods.setPrice(goods.getPrice());
        goodsRepository.save(oldGoods);
        return "redirect:/allGoods/";
    }

    @RequestMapping(value = "/deleteGoods/{goodsId}", method = GET)
    public String deleteOrder(@PathVariable Long goodsId) {
        goodsRepository.deleteById(goodsId);
        return "redirect:/allGoods/";
    }

    @RequestMapping("/goodsById/")
    public String goodsById(Model model, @RequestParam("searchID") Long id) {
        List<Goods> goodsList = new ArrayList<>();
        if (goodsRepository.existsById(id)) {
            Goods goods = goodsRepository.getOne(id);
            goodsList.clear();
            goodsList.add(goods);
            model.addAttribute("allGoods", goodsList);
            return "allGoods";
        }
        else return "/noSuchOrder";
    }


}
