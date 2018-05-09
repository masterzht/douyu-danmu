package com.zht.service;

import com.zht.dao.entity.DanmuInfo;

/**
 * 对斗鱼弹幕进行操作
 * Created by masterzht on 2018/5/9.
 */
public interface IDanmu {

    /*查询弹幕*/
    public DanmuInfo searchBarrage();

    /*保存弹幕*/
    public void saveBarrage(DanmuInfo danmuInfo);

}
