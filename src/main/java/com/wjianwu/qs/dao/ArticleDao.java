package com.wjianwu.qs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wjianwu.qs.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wjianwu
 * @since 2019-03-19
 */
public interface ArticleDao extends BaseMapper<Article> {

    Map selectArticleDetail(@Param("articleId") int articleId);

    List<Article> selectAllArticle(Map map);
}
