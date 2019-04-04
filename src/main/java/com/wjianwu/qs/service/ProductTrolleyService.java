package com.wjianwu.qs.service;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
public interface ProductTrolleyService {

    void saveProductTrolley(int productId);

    int querySingleProduct(int productId);

    List<Map> queryProductTrolley();

}
