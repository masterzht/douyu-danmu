package com.zht.controller;

import com.zht.model.douyuapi.RoomInfBean;
import com.zht.service.impl.DouyuApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by masterzht on 2018/4/8.
 *
 * 作api用
 */
@RestController
public class DouyuApiController {

    @Autowired
    public DouyuApiServiceImpl douyuService;





}
