package com.wjianwu.qs.dao;

import com.wjianwu.qs.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author wjianwu
 * @since 2019-02-26
 */
public interface UserDao extends BaseMapper<User> {

    User selectByAccount(String account);

}
