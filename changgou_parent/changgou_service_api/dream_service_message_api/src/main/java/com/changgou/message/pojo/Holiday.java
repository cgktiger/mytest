package com.changgou.message.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="gift")
public class Holiday implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "gift_name")
    private String giftName;//礼物名称
    @Column(name = "gift_price")
    private Integer gift_price;//礼物价格
    @Column(name = "gift_img")
    private String gift_img;//礼物图片


}
