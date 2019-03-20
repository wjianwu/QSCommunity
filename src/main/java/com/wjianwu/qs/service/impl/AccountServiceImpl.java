package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.common.ShiroUtils;
import com.wjianwu.qs.dao.AccountDao;
import com.wjianwu.qs.entity.Account;
import com.wjianwu.qs.service.AccountService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void addAccount(String account, String username, String password) {

        Account accountEntity = new Account();
        accountEntity.setAccount(account);
        accountEntity.setUsername(username);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        accountEntity.setPwdSalt(salt);
        accountEntity.setPassword(ShiroUtils.encrypt(password, salt));
        accountDao.insert(accountEntity);

    }

    @Override
    public boolean checkAccount(String account) {
        return accountDao.manyAccount(account) > 0;
    }
}
