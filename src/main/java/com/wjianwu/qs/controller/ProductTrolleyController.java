package com.wjianwu.qs.controller;


import com.wjianwu.qs.common.R;
import com.wjianwu.qs.service.ProductTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
@Controller
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
            int productId = Integer.parseInt((String) map.get("productId"));
            int number = (Integer) map.get("number");
            productTrolleyService.saveProductTrolley(productId, number);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }
}

