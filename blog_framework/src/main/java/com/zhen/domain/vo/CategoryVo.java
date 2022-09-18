package com.zhen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 甄子函
 * @date: 2022/8/25__13:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryVo {

    private Long id;
    //分类名
    private String name;
}
