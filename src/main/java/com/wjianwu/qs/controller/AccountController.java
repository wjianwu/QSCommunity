package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.R;
import com.wjianwu.qs.entity.Account;
import com.wjianwu.qs.service.AccountService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 登录逻辑 Controller
     *
     * @param map account password
     * @return code
     */
    @RequestMapping("/login")
    public R userLogin(@RequestBody Map map) {
        try {
            String account = (String) map.get("account");
            String password = (String) map.get("password");

            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(account, password);
            subject.login(token);
            Account accountEntity = (Account) subject.getPrincipal();
            return R.ok().put("accountId", accountEntity.getAccountId());
        } catch (UnknownAccountException e) {
            return R.error(100, "账号不存在！");
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 注册逻辑 Controller
     *
     * @param map email/phone username password repeatPwd
     * @return code
     */
    @RequestMapping("/register")
    public R userRegister(@RequestBody Map map) {

        try {
            String account = (String) map.get("account");
            String username = (String) map.get("username");
            String password = (String) map.get("password");
            String repeatPwd = (String) map.get("repeatPwd");
            if (!password.equals(repeatPwd)) {
                return R.error("两次密码不一样，请重新输入！");
            }
            if (accountService.checkAccount(account)) {
                return R.error("该账号已被注册！");
            }
            accountService.addAccount(account, username, password);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 上传文件（本地路径） Controller
     *
     * @param file file
     * @return code
     */
    @RequestMapping("/upload")
    public R uploadImage(@RequestParam("file") MultipartFile file) {

        try {
            if (!file.isEmpty()) {
                // 上传目录
                File upload = new File(ResourceUtils.getURL("src/main/resources/static/upload").getPath());
                String uploadPath = upload.getPath();
                // 文件名
                String filename = file.getOriginalFilename();
                File newFile = new File(uploadPath + File.separator + filename);
                file.transferTo(newFile);
                return R.ok();
            }
            return R.error("出现错误，文件为空！");
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 获取用户信息
     *
     * @return code
     */
    @RequestMapping("/info")
    public R queryInfo() {

        try {
            Subject subject = SecurityUtils.getSubject();
            Account account = (Account) subject.getPrincipal();
            return R.ok().put("account", account);
        } catch (Exception e) {
            return R.error();
        }
    }

}

