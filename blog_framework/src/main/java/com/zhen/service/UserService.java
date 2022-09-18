package com.zhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.User;


/**
 * 用户表(User)表服务接口
 *
 * @author makejava
 * @since 2022-09-12 18:03:32
 */
public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);

    ResponseResult register(User user);
}
