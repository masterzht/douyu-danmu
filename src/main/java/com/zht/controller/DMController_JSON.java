package com.zht.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by masterzht on 2018/4/8.
 */
@RestController
public class DMController_JSON {

    @Value("$(msg)")
    private String msg;

    @RequestMapping("/index1")
    public String index1(){
        return "方式一:"+msg;
    }

}
