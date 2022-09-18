package com.zhen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author 甄子函
 * @date: 2022/9/9__9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {


    private Long id;

    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;

    //所回复的目标评论的用户名
    private String toCommentUserName;

    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private String username;

    private List<CommentVo> children;


}
