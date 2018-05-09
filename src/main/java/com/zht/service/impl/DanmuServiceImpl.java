package com.zht.service.impl;

import com.zht.danmu.client.DmClient;
import com.zht.dao.entity.DanmuInfo;
import com.zht.dao.repository.DanmuRepository;
import com.zht.service.IDanmu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

/**
 * Created by masterzht on 2018/5/9.
 */
@Service
public class DanmuServiceImpl implements IDanmu {
    @Autowired
    private DanmuRepository danmuRepository;

    private static String preName = "";
    private static String preText="";

    @Override
    public DanmuInfo searchBarrage() {
        DanmuInfo danmuInfo = new DanmuInfo();

        /*获取弹幕，存储到danmuInfo类*/
        String senderid= DmClient.getSenderid();
        String senderlevel= DmClient.getSenderlevel();
        String userName = DmClient.getName();
        String userText = DmClient.getText();

        /*如果这次获取的姓名和内容都和之前一样，或者username为null那就取消掉*/
        if(userName == null) {
            return null;
        }else if (userName.equals(preName)&&userText.equals(preText)) {
            return null;
        }
        preName = userName;
        preText=userText;

        danmuInfo.setTime(Calendar.getInstance().getTime());
        danmuInfo.setSenderid(senderid);
        danmuInfo.setSenderlevel(senderlevel);
        danmuInfo.setName(userName);
        danmuInfo.setText(userText);
        return danmuInfo;
    }

    @Override
    public void saveBarrage(DanmuInfo danmuInfo) {

        if(danmuInfo!=null){
            danmuRepository.save(danmuInfo);
        }
    }
}
