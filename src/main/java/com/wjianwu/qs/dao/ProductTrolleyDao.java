package com.wjianwu.qs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjianwu.qs.entity.ProductTrolley;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
public interface ProductTrolleyDao extends BaseMapper<ProductTrolley> {

    List<Map> selectProductTrolley(int accountId);
}
