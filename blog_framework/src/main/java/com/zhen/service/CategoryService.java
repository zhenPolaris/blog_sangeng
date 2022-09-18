package com.zhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-08-25 09:40:39
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();

}
