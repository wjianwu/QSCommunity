package com.wjianwu.qs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjianwu.qs.entity.Product;

import java.util.List;

/**
 * @author wjianwu
 * @since 2019-03-28
 */
public interface ProductDao extends BaseMapper<Product> {

    List<Product> selectAllProduct(String productName);
}
