package com.zhen.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2022-09-01 10:22:36
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
