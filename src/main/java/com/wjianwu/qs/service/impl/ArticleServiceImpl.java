package com.wjianwu.qs.service.impl;

import com.wjianwu.qs.dao.ArticleDao;
import com.wjianwu.qs.entity.Article;
import com.wjianwu.qs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<Article> queryAllArticle() {
        return articleDao.selectAllArticle();
    }
}
