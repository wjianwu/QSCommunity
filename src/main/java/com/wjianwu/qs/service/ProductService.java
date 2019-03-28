package com.wjianwu.qs.service;

import com.wjianwu.qs.entity.Product;

import java.util.List;

/**
 * @author wjianwu
 * @since 2019-03-28
 */
public interface ProductService {

    Product queryProductDetail(int productId);

    List<Product> queryAllProduct();
}
