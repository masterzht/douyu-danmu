package com.zht.controller;



import com.google.gson.Gson;
import com.zht.domain.DMRepository;
import com.zht.domain.DanMu;
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
        DanMu danMu = new DanMu();
        String userName = DMClient.getName();
        String userText = DMClient.getText();
        danMu.setName(userName);
        danMu.setText(userText);

        if(userName == null)
            return null;
        if (userName.equals(preName)) {
            return null;
        }
        preName = userName;
        dmRepository.save(danMu);
        Gson gson = new Gson();
        user.put("name", userName);
        user.put("text", userText);
        String gsonStr = gson.toJson(user);
        return gsonStr;
    }
}
