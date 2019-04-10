package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.dao.ArticleDao;
import com.wjianwu.qs.entity.Account;
import com.wjianwu.qs.entity.Article;
import com.wjianwu.qs.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public void saveArticle(Article article) {
        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setAccountId(account.getAccountId());
        // 保存草稿 状态为 0
        article.setStatus(0);
        article.setLikeCount(0);
        article.setCommentCount(0);
        article.setCollectionCount(0);
        articleDao.insert(article);
    }

    @Override
    public Map queryArticleDetail(int articleId) {
        return articleDao.selectArticleDetail(articleId);
    }

    @Override
    public List<Article> queryAllArticle(Map map) {
        return articleDao.selectAllArticle(map);
    }
}
