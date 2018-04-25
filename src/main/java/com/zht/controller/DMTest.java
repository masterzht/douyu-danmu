package com.zht.controller;




import com.zht.service.impl.DanmuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by masterzht on 2018/4/8.
 */
@Controller
public class DMTest {


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
    public String greetingSubmit(@RequestParam("search") Integer search,Model model) {
        System.out.println(search);
        DanmuServiceImpl.start(search);
        model.addAttribute("search",search);
        return "test";
    }

}
