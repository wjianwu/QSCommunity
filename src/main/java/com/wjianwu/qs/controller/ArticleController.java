package com.wjianwu.qs.controller;

import com.wjianwu.qs.common.Result;
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
    public Result showAllArticle() {
        try {
            List<Article> articleList = articleService.queryAllArticle();
            return Result.ok();
        } catch (Exception e) {
            return Result.error();
        }
    }
}

