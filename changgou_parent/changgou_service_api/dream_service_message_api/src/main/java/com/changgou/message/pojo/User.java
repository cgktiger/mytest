package com.changgou.message.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="role")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "user_openid")
    private String userOpenid;//用户标识
    @Column(name = "players_id")
    private String playersId;//选手标识
    @Column(name = "times")
    private String times;//投票时间
    @Column(name = "prices")
    private String prices;//用户余额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getPlayersId() {
        return playersId;
    }

    public void setPlayersId(String playersId) {
        this.playersId = playersId;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }
}
