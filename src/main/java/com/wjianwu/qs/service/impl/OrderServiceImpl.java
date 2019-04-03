package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.dao.OrderDao;
import com.wjianwu.qs.entity.Account;
import com.wjianwu.qs.entity.Order;
import com.wjianwu.qs.service.OrderService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author wjianwu
 * @since 2019-04-02
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void buyProductSingle(int productId, int serialNum) {
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();

        Order order = new Order();
        order.setAccountId(account.getAccountId());
        order.setProductId(productId);
        order.setCreateTime(LocalDateTime.now());
        order.setOrderTitle("购买商品");
        order.setOrderSerialNum(serialNum);
        order.setOrderStatus(1);
        orderDao.insert(order);
    }
}
