package com.zhen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 甄子函
 * @date: 2022/8/24__20:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleListVo {

    private Long id;

    //标题
    private String title;

    //访问量
    private Long viewCount;
}
