package com.zht.dydanmu.utils;

import com.zht.dydanmu.client.DmClient;

public class KeepGetMsg extends Thread {

	@Override
    public void run()
    {
		////获取弹幕客户端
    	DmClient danmuClient = DmClient.getInstance();
    	
    	//判断客户端就绪状态
        while(danmuClient.getReadyFlag())
        {
        	//获取服务器发送的弹幕信息
        	danmuClient.getServerMsg();;
        }
    }
}
