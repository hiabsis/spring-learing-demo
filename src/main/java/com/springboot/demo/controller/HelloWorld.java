package com.springboot.demo.controller;

import com.springboot.demo.aop.annotation.LogAction;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author      : cyw
 * @date        : created in  下午3:58 2021/4/26
 * @description :
 * @modified by :
 * @Version : $
 */
@SuppressWarnings("ALL")
@RestController
@LogAction(name = "ss")
public class HelloWorld {
    @RequestMapping("/first")
    public Object first() {
        return "first controller";
    }

    @RequestMapping("/doError")
    public Object error() {
        return 1 / 0;
    }


}
