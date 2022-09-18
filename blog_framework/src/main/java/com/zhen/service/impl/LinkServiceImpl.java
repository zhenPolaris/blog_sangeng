package com.zhen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhen.constants.SystemConstants;
import com.zhen.domain.ResponseResult;
import com.zhen.domain.entity.Link;
import com.zhen.domain.vo.LinkVo;
import com.zhen.mapper.LinkMapper;
import com.zhen.service.LinkService;
import com.zhen.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-08-28 22:56:55
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper,Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {

        //查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //转换成vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        //封装返回
        return ResponseResult.okResult(linkVos);

    }
}
