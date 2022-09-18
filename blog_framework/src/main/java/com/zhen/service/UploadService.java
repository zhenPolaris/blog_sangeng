package com.zhen.service;

import com.zhen.domain.ResponseResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 甄子函
 * @date: 2022/9/13__21:22
 */
public interface UploadService {
    ResponseResult uploadImg(MultipartFile img);

}
