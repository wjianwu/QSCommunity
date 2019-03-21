package com.wjianwu.qs.service;

import com.wjianwu.qs.entity.Account;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
public interface AccountService {

    boolean checkAccount(String account);

    void addAccount(String account, String username, String password);

    Account queryAccountInfo(Integer accountId);

}
