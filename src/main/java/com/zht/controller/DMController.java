package com.zht.controller;
import com.google.gson.Gson;
import com.zht.domain.DMRepository;
import com.zht.domain.DanMuInfo;
import com.zht.dyDanMu.client.DMClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DMController {

    @Autowired
    private DMRepository dmRepository;

    private static String preName = "";
    private static String preText="";

    @GetMapping(value = "/danmu")
    public String highCharts() {
        return "dyDanMu";
    }

    @RequestMapping("/test")
    public String test(){
       return "test";
    }


    @PostMapping("/add")
    @ResponseBody
    public String danMuAdd() {
        Map<String, String> user = new HashMap<>();
        DanMuInfo danMuInfo = new DanMuInfo();

        String senderid=DMClient.getSenderid();
        String senderlevel=DMClient.getSenderlevel();
        String userName = DMClient.getName();
        String userText = DMClient.getText();

        danMuInfo.setTime(Calendar.getInstance().getTime());
        danMuInfo.setSenderid(senderid);
        danMuInfo.setSenderlevel(senderlevel);
        danMuInfo.setName(userName);
        danMuInfo.setText(userText);



        if(userName == null)
            return null;
        /*如果这次获取的姓名和内容都和之前一样，那就取消掉*/
        if (userName.equals(preName)&&userText.equals(preText)) {
            return null;
        }
        preName = userName;
        preText=userText;
        dmRepository.save(danMuInfo);


        Gson gson = new Gson();
        user.put("name", userName);
        user.put("text", userText);
        String gsonStr = gson.toJson(user);
        return gsonStr;
    }
}
