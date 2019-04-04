package com.wjianwu.qs.controller;


import com.wjianwu.qs.common.R;
import com.wjianwu.qs.service.ProductTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
@RestController
@RequestMapping("/productTrolley")
public class ProductTrolleyController {

    @Autowired
    private ProductTrolleyService productTrolleyService;

    /**
     * 购物车列表显示
     *
     * @return ok error
     */
    @RequestMapping("/list")
    public R ProductTrolleyList() {
        try {
            List<Map> productTrolleys = productTrolleyService.queryProductTrolley();
            return R.ok().put("productTrolleys", productTrolleys);
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 添加至购物车
     *
     * @param map productId serialNum
     * @return ok error
     */
    @RequestMapping("/save")
    public R ProductTrolleySave(@RequestBody Map map) {
        try {
            int productId = (Integer) map.get("productId");

            if (productTrolleyService.querySingleProduct(productId) != 0) {
                return R.error(100, "物品已在购物车了哦！");
            }

            productTrolleyService.saveProductTrolley(productId);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }
}

