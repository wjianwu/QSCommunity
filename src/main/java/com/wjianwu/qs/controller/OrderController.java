package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.R;
import com.wjianwu.qs.service.OrderService;
import com.wjianwu.qs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-02
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 直接购买商品
     *
     * @param map productId serialNum
     * @return ok error
     */
    @RequestMapping("/buy")
    public R buyProduct(@RequestBody Map map) {
        try {
            int productId = Integer.parseInt((String) map.get("productId"));
            int serialNum = (Integer) map.get("serialNum");
            orderService.buyProductSingle(productId, serialNum);
            return R.ok().put("product", 1);
        } catch (Exception e) {
            return R.error();
        }
    }

}

