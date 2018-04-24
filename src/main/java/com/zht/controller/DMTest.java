package com.zht.controller;


import com.zht.entity.shiro.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * Created by masterzht on 2018/4/8.
 */
@Controller
public class DMTest {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/dywordcloud")
    public String dywordcloud(){
        return "dywordcloud";
    }

    @GetMapping(value = "/dywordcloud2")
    public String dywordcloud2(){
        return "dywordcloud2";
    }

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    @GetMapping(value="/sayhello")
    public String greetingSubmit( Model model) {
        return "test";
    }

}
