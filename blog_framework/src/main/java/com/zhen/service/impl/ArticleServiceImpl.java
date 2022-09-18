package com.zhen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhen.constants.SystemConstants;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Article;
import com.zhen.domain.entity.Category;
import com.zhen.domain.vo.ArticleDetailVo;
import com.zhen.domain.vo.ArticleListVo;
import com.zhen.domain.vo.HotArticleListVo;
import com.zhen.domain.vo.PageVo;
import com.zhen.mapper.ArticleMapper;
import com.zhen.mapper.CategoryMapper;
import com.zhen.service.ArticleService;
import com.zhen.service.CategoryService;
import com.zhen.utils.BeanCopyUtils;
import com.zhen.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 甄子函
 * @date: 2022/8/22__20:28
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章 封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //只查询十条
        Page<Article> page = new Page<>(1,10);
        page(page,queryWrapper);

        //获取article列表
        List<Article> articles = page.getRecords();

        // //数据库信息不能都传输到前端，封装成vo对象，只传需要的数据
        // List<HotArticleListVo> articleVos = new ArrayList<>();
        // for (Article article : articles) {
        //     HotArticleListVo vo = new HotArticleListVo();
        //     //spring工具类。自动拷贝相同名字类型的属性,（源对象，拷贝到的对象）
        //     BeanUtils.copyProperties(article,vo);
        //     articleVos.add(vo);
        // }

        List<HotArticleListVo> vs = BeanCopyUtils.copyBeanList(articles, HotArticleListVo.class);

        //bean拷贝

        return ResponseResult.okResult(vs);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询条件
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        //如果传入categoryId 查询时要和传入id相同
        wrapper.eq(Objects.nonNull(categoryId) && categoryId > 0,Article::getCategoryId,categoryId);
        //状态是已发布
        wrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        //isTop降序排序
        wrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,wrapper);

        //查询categoryName封装到vo中
        List<Article> articles = page.getRecords();

        //更新首页文章浏览量
        // articles.stream()
        //         .map(article -> article.setViewCount(redisCache.getCacheMapValue("article:viewCount", article.getId().toString())))
        //         .collect(Collectors.toList());
        //用得到的categoryId查询对应的categoryName
        articles.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                //从redis中读取浏览量数据
                .map(article -> article.setViewCount(((Integer)redisCache.getCacheMapValue("article:viewCount", article.getId().toString())).longValue()))
                .collect(Collectors.toList());

        //获取article列表
        //封装articleListVo(封装文章属性中，需要发送给前端的字段)
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);


        //封装PageVo封装分页相关数据
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());

        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id查询文章
        Article article = getById(id);
        //从Redis中获取 浏览量信息
        Integer viewCount = redisCache.getCacheMapValue("article:viewCount", id.toString());
        article.setViewCount(viewCount.longValue());
        //转换成VO
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        //根据分类id查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        if(category!=null){
            articleDetailVo.setCategoryName(category.getName());
        }
        //封装响应返回
        return ResponseResult.okResult(articleDetailVo);
    }

    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新redis中对应 id的浏览量
        redisCache.incrementCacheMapValue("article:viewCount",id.toString(),1);
        return ResponseResult.okResult();
    }

}
