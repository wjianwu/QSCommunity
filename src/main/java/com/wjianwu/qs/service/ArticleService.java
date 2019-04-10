package com.wjianwu.qs.service;

import com.wjianwu.qs.entity.Article;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
public interface ArticleService {

    void saveArticle(Article article);

    Map queryArticleDetail(int articleId);

    List<Article> queryAllArticle(Map map);
}
