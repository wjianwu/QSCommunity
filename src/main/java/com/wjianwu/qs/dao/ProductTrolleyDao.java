package com.wjianwu.qs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjianwu.qs.entity.ProductTrolley;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
public interface ProductTrolleyDao extends BaseMapper<ProductTrolley> {

    int selectSingleProduct(@Param("accountId") int accountId, @Param("productId") int productId);

    List<Map> selectProductTrolley(int accountId);
}
