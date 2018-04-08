package com.zht.controller;
import com.google.gson.Gson;
import com.zht.domain.DMRepository;
import com.zht.domain.DanMuInfo;
import com.zht.dyDanMu.client.DMClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DMController {

    @Autowired
    private DMRepository dmRepository;

    private static String preName = "";

    @GetMapping(value = "/danmu")
    public String highCharts() {
        return "dyDanMu";
    }

    @PostMapping("/add")
    @ResponseBody
    public String danMuAdd() {
        Map<String, String> user = new HashMap<>();
        DanMuInfo danMuInfo = new DanMuInfo();
        String userName = DMClient.getName();
        String userText = DMClient.getText();
        danMuInfo.setName(userName);
        danMuInfo.setText(userText);

        if(userName == null)
            return null;
        /*这里的判断有问题*/
        if (userName.equals(preName)) {
            return null;
        }
        preName = userName;
        dmRepository.save(danMuInfo);


        Gson gson = new Gson();
        user.put("name", userName);
        user.put("text", userText);
        String gsonStr = gson.toJson(user);
        return gsonStr;
    }
}
