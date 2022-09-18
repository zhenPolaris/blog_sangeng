package com.zhen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhen.domain.entity.Article;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 甄子函
 * @date: 2022/8/22__20:25
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
