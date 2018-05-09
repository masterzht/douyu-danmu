package com.zht.danmu.api;

import com.zht.model.douyuapi.RoomInfBean;
import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Path;


/**
 * Created by masterzht on 2018/4/11.
 */
public interface DouYuApi {
    String   url = "http://open.douyucdn.cn/api/";

    @GET("RoomApi/room/{roomid}")
    Call<RoomInfBean> getZhihuDetail(@Path("roomid") Integer roomid) ;

}
