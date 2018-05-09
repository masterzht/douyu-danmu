package com.zht.service;

import com.zht.model.douyuapi.RoomInfBean;

/**
 * 通过斗鱼提供的api获取数据
 * Created by zht on 2018/4/24.
 */
public interface IDouyuApi {


    /*返回直播间的json文件*/
    public RoomInfBean getcontent();

    /*返回直播间开播状态*/
    public String room_status();
}
