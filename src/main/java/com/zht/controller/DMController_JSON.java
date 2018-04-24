package com.zht.controller;

import com.zht.danmu.api.DouYuApi;
import com.zht.entity.dyapi.Room_Inf;
import com.zht.service.impl.DouyuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by masterzht on 2018/4/8.
 */
@RestController
public class DMController_JSON {

    @Autowired
    public DouyuServiceImpl douyuService;

    @Value("$(msg)")
    private String msg;

    @RequestMapping("/index1")
    public String index1(){
        return "方式一:"+msg;
    }


    /*@GetMapping(value = "/danmuinfo")
            public String getMsg(@RequestParam(value="name", defaultValue="World") String name)
    {

    }*/

    @GetMapping(value = "/douyu-api")
    public Room_Inf douyu_api(){
        /*Retrofit retrofit = new Retrofit.Builder().
                baseUrl(DouYuApi.url).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        DouYuApi douyuapi=retrofit.create(DouYuApi.class);
        Call<Room_Inf> call=douyuapi.getZhihuDetail(643037);
        try {
            Response<Room_Inf> res=call.execute();
            return res.body();
        } catch (IOException e) {
            e.printStackTrace();  //会堵塞主线程，因为是同步请求
        }
        return null;*/
        return douyuService.getcontent();
    }
    /*看房间有没有开播*/
    @GetMapping(value = "/room_status")
    public String room_status(){
        return douyuService.room_status();
    }

}
