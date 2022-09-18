package com.zhen.annotation;

import org.aspectj.lang.annotation.Around;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 甄子函
 * @date: 2022/9/14__20:59
 */
@Retention(RetentionPolicy.RUNTIME)//注解保持到哪个阶段
@Target({ElementType.METHOD})//注解作用在哪里
public @interface SystemLog {

    String businessName();
}
