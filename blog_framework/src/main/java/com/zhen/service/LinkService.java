package com.zhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-08-28 22:56:55
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();
}
