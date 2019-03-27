package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.R;
import com.wjianwu.qs.entity.Article;
import com.wjianwu.qs.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/list")
    public R showAllArticle(@RequestBody Map map) {
        try {
            List<Article> articleList = articleService.queryAllArticle(map);
            return R.ok().put("articles", articleList);
        } catch (Exception e) {
            return R.error();
        }
    }

    @RequestMapping("/save")
    public R saveArticle(@RequestBody Article article) {
        try {
            articleService.saveArticle(article);
            return R.ok();
        } catch (Exception e) {
            return R.error();
        }
    }
}

