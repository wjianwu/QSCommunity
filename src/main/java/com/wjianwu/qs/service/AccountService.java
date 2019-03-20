package com.wjianwu.qs.service;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
public interface AccountService{

    void addAccount(String account, String username, String password);

    boolean checkAccount(String account);

}
