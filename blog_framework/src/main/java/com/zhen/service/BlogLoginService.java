package com.zhen.service;

import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.User;

/**
 * @author 甄子函
 * @date: 2022/8/29__14:08
 */
public interface BlogLoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}
