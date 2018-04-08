package com.zht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by masterzht on 2018/4/8.
 */
@Controller
public class DMTest {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
