package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.common.CommonUtil;
import com.wjianwu.qs.dao.ProductTrolleyDao;
import com.wjianwu.qs.entity.Account;
import com.wjianwu.qs.entity.ProductTrolley;
import com.wjianwu.qs.service.ProductTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-04-03
 */
@Service
public class ProductTrolleyServiceImpl implements ProductTrolleyService {

    @Autowired
    private ProductTrolleyDao productTrolleyDao;

    @Override
    public void saveProductTrolley(int productId) {
        Account account = CommonUtil.getAccount();

        ProductTrolley productTrolley = new ProductTrolley();
        productTrolley.setProductId(productId);
        productTrolley.setAccountId(account.getAccountId());
        productTrolley.setNumber(1);
        productTrolley.setCreateTime(LocalDateTime.now());
        productTrolleyDao.insert(productTrolley);
    }

    @Override
    public void removeProductTrolley(int productId) {
        productTrolleyDao.deleteByProductId(productId);
    }

    @Override
    public int querySingleProduct(int productId) {
        Account account = CommonUtil.getAccount();

        return productTrolleyDao.selectSingleProduct(account.getAccountId(), productId);
    }

    @Override
    public List<Map> queryProductTrolley() {
        Account account = CommonUtil.getAccount();

        return productTrolleyDao.selectProductTrolley(account.getAccountId());
    }
}
