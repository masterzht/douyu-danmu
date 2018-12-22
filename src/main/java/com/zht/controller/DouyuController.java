package com.zht.controller;

import com.zht.dao.entity.DanmuInfo;
import com.zht.model.douyuapi.RoomInfBean;
import com.zht.service.impl.DanmuServiceImpl;
import com.zht.service.impl.DouyuApiServiceImpl;
import com.zht.service.impl.StartBarrageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by masterzht on 2018/5/9.
 */
@Controller
public class DouyuController {
    @Autowired
    private StartBarrageServiceImpl startBarrage;

    @Autowired
    private DanmuServiceImpl danmuService;

    @Autowired
    private DouyuApiServiceImpl douyuApiService;

    /**
     * localhost:8080/
     *
     * @return
     */
    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("short_name", "all");
        return "/recommend/rec_head";
    }

    @GetMapping(value = "/s")
    public String search() {
        return "index";
    }

    /**
     * localhost:8080/search?roomid=643037
     *
     * @param roomid
     * @param model
     * @return
     */
    @GetMapping(value = "/search")
    public String searchRoomId(@RequestParam("roomid") Integer roomid, Model model) {
        RoomInfBean roomInfBean = douyuApiService.getcontent(roomid);
        model.addAttribute("roominfo", roomInfBean);
        /*开启弹幕服务器，启动弹幕查询*/
        startBarrage.start(roomid);
        model.addAttribute("roomid", roomid);
        return "analysis";
    }

    /**
     * localhost:8080/643037
     *
     * @param roomid
     * @param model
     * @return 斗鱼房间的具体数据分析情况
     */
    @GetMapping("/{roomid}")
    public String getRoom(@PathVariable("roomid") Integer roomid, Model model) {
        startBarrage.start(roomid);
        RoomInfBean roomInfBean = douyuApiService.getcontent(roomid);
        model.addAttribute("roominfo", roomInfBean);
        model.addAttribute("roomid", roomid);
        return "analysis";
    }

    /**
     * localhost:8080/danmu?roomid=643037
     *
     * @param roomid
     * @param model
     * @return 单单返回这个房间的弹幕
     */
    @GetMapping("/danmu")
    public String getDanmu(@RequestParam("roomid") Integer roomid, Model model) {
        startBarrage.start(roomid);
        model.addAttribute("roomid", roomid);
        return "danmu";
    }




    /**
     * 添加弹幕
     *
     * @return
     */
    @PostMapping("/addbarrage")
    @ResponseBody
    public DanmuInfo danMuAdd() {
        DanmuInfo danmuInfo = danmuService.searchBarrage();
        danmuService.saveBarrage(danmuInfo);
        return danmuInfo;
    }


}
