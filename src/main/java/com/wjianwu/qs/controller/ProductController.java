package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.R;
import com.wjianwu.qs.entity.Product;
import com.wjianwu.qs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-28
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * 展示商品列表
     *
     * @return articleList
     */
    @RequestMapping("/list")
    public R showAllProduct() {
        try {
            List<Product> articleList = productService.queryAllProduct();
            return R.ok().put("products", articleList);
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 展现商品详情
     *
     * @param map productId
     * @return product
     */
    @RequestMapping("/info")
    public R showProductDetail(@RequestBody Map map) {
        try {
            int productId = Integer.parseInt((String) map.get("productId"));
            Product product = productService.queryProductDetail(productId);
            return R.ok().put("product", product);
        } catch (Exception e) {
            return R.error();
        }
    }
}

