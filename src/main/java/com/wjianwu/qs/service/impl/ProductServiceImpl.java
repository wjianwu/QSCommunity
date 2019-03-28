package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.dao.ProductDao;
import com.wjianwu.qs.entity.Product;
import com.wjianwu.qs.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjianwu
 * @since 2019-03-28
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product queryProductDetail(int productId) {
        return productDao.selectById(productId);
    }

    @Override
    public List<Product> queryAllProduct() {
        return productDao.selectAllProduct();
    }
}
