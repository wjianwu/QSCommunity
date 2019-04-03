package com.wjianwu.qs.common;

import com.wjianwu.qs.entity.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * @author wjianwu 2019/4/3 11:28
 */
public class CommonUtil {

    public static Account getAccount() {
        Subject subject = SecurityUtils.getSubject();
        return (Account) subject.getPrincipal();
    }
}
