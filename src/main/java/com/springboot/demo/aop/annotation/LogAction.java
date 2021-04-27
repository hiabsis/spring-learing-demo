package com.springboot.demo.aop.annotation;

import java.lang.annotation.*;

/**
 * @author : cyw
 * @date : created in  下午4:42 2021/4/26
 * @description :
 * @modified by :
 * @Version : $
 */

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAction {
    String name();
}
