package com.zhen.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhen.domain.entity.Tag;
import com.zhen.mapper.TagMapper;
import com.zhen.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签(Tag)表服务实现类
 *
 * @author makejava
 * @since 2022-09-16 15:55:59
 */
@Service("tagService")
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
