package com.wjianwu.qs.dao;

import com.wjianwu.qs.entity.Account;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
public interface AccountDao extends BaseMapper<Account> {

    int manyAccount(String account);

    Account selectByAccount(String account);
}
