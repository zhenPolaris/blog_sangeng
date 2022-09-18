package com.zhen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 友联vo
 * @author 甄子函
 * @date: 2022/8/29__8:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {
    private Long id;


    private String name;

    private String logo;

    private String description;
    //网站地址
    private String address;
}
