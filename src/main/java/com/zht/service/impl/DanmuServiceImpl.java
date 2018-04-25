package com.zht.service.impl;

import com.zht.danmu.client.DmClient;
import com.zht.danmu.utils.KeepAlive;
import com.zht.danmu.utils.KeepGetMsg;

/**
 * Created by masterzht on 2018/4/25.
 */
public class DanmuServiceImpl {

    //设置需要访问的房间ID信息
    //private static final int roomId = 301712;

    //弹幕池分组号，海量模式使用-9999
    private static final int groupId = -9999;

    public static void start(int roomId)
    {
        //初始化弹幕Client
        DmClient danmuClient = DmClient.getInstance();
        //设置需要连接和访问的房间ID，以及弹幕池分组号
        danmuClient.init(roomId, groupId);

        //保持弹幕服务器心跳
        KeepAlive keepAlive = new KeepAlive();
        keepAlive.start();

        //获取弹幕服务器发送的所有信息
        KeepGetMsg keepGetMsg = new KeepGetMsg();
        keepGetMsg.start();
    }
}
