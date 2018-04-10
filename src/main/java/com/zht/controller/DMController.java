package com.zht.controller;
import com.google.gson.Gson;
import com.zht.entity.DMRepository;
import com.zht.entity.DanMuInfo;
import com.zht.dydanmu.client.DmClient;
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
        return "dydanmu";
    }

    @RequestMapping("/test1")
    public String test(){
       return "/login/login";
    }


    @PostMapping("/add")
    @ResponseBody
    public String danMuAdd() {
        Map<String, String> user = new HashMap<>();
        DanMuInfo danMuInfo = new DanMuInfo();

        String senderid= DmClient.getSenderid();
        String senderlevel= DmClient.getSenderlevel();
        String userName = DmClient.getName();
        String userText = DmClient.getText();

        danMuInfo.setTime(Calendar.getInstance().getTime());
        danMuInfo.setSenderid(senderid);
        danMuInfo.setSenderlevel(senderlevel);
        danMuInfo.setName(userName);
        danMuInfo.setText(userText);



        if(userName == null) {
            return null;
        }
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
