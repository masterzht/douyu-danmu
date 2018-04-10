package com.zht.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
//数据库的表保存的时候的名字，可以自定义
@Table(name = "DanMuInfo")
public class DanMuInfo {
    //自动生成，不用写
    @Id
    @GeneratedValue
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date time;
    @Column(columnDefinition = "VARCHAR(40)")
    private String name;
    private String text;
    private String senderid;
    //弹幕发送者等级
    private String senderlevel;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSenderid() {
        return senderid;
    }

    public void setSenderid(String senderid) {
        this.senderid = senderid;
    }

    public String getSenderlevel() {
        return senderlevel;
    }

    public void setSenderlevel(String senderlevel) {
        this.senderlevel = senderlevel;
    }

    public DanMuInfo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
