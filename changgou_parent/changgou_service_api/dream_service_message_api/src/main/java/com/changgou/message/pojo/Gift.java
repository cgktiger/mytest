package com.changgou.message.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="holiday")
public class Gift implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;//节目名称
    @Column(name = "slogan")
    private String slogan;//节目口号
    @Column(name = "aim")
    private String aim;//节目宗旨
    @Column(name = "orientation")
    private String orientation;//节目定位
    @Column(name = "content_title")
    private String contentTitle;//内容小标题
    @Column(name = "content")
    private String content;//节目内容
    @Column(name = "compere")
    private String compere;//主持人
    @Column(name = "broadcast")
    private String broadcast;//播出形式
    @Column(name = "audiences")
    private String audiences;//受众分析
    @Column(name = "effect")
    private String effect;//节目效果预测

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getAim() {
        return aim;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompere() {
        return compere;
    }

    public void setCompere(String compere) {
        this.compere = compere;
    }

    public String getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(String broadcast) {
        this.broadcast = broadcast;
    }

    public String getAudiences() {
        return audiences;
    }

    public void setAudiences(String audiences) {
        this.audiences = audiences;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
}
