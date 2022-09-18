package com.zhen.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 甄子函
 * @date: 2022/8/25__21:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {

    private List rows;
    private Long total;
}
