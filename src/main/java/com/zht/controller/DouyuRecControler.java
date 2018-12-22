package com.zht.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author masterzht
 */
@Controller
@RequestMapping(value = "/category")
public class DouyuRecControler {




    @GetMapping("/{short_name}")
    public String getRoom(@PathVariable("short_name") String short_name, Model model) {
        model.addAttribute("short_name", short_name);
        return "/recommend/rec_head";
    }

}
