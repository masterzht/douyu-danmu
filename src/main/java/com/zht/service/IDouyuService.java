package com.zht.service;

import com.zht.entity.dyapi.Room_Inf;

/**
 * Created by zht on 2018/4/24.
 */
public interface IDouyuService {


    /*返回直播间的json文件*/
    public Room_Inf getcontent();

    /*返回直播间开播状态*/
    public String room_status();
}
