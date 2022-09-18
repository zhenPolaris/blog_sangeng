package com.zhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Article;

/**
 * @author 甄子函
 * @date: 2022/8/22__20:27
 */

public interface ArticleService extends IService<Article> {

    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);

    ResponseResult updateViewCount(Long id);
}
