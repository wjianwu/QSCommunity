package com.wjianwu.qs.shiro;

import com.wjianwu.qs.common.ShiroUtils;
import com.wjianwu.qs.dao.AccountDao;
import com.wjianwu.qs.entity.Account;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wjianwu 2019/2/26 16:50
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private AccountDao accountDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Account account = accountDao.selectByAccount(token.getUsername());
        if (account == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(account, account.getPassword(), ByteSource.Util.bytes(account.getPwdSalt()), getName());
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
