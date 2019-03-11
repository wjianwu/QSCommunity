package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.entity.User;
import com.wjianwu.qs.dao.UserDao;
import com.wjianwu.qs.service.UserService;
import com.wjianwu.qs.common.ShiroUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wjianwu
 * @since 2019-02-26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(String account, String username, String password) {
        User user = new User();
        user.setAccount(account);
        user.setUserName(username);
        String salt = RandomStringUtils.randomAlphanumeric(20);
        user.setPasswordSalt(salt);
        user.setPassword(ShiroUtils.encrypt(password, salt));
        userDao.insert(user);
    }

    @Override
    public boolean checkAccount(String account) {
        return userDao.manyAccount(account) > 0;
    }
}
