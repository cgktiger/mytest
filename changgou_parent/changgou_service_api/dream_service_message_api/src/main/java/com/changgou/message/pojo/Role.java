package com.changgou.message.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name="role")
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "role_img")
    private String roleImg;//角色图片
    @Column(name = "role_name")
    private String roleName;//角色名字
    @Column(name = "role_number")
    private String roleNumber;//角色编号
    @Column(name = "role_con")
    private String roleCon;//角色内容

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleImg() {
        return roleImg;
    }

    public void setRoleImg(String roleImg) {
        this.roleImg = roleImg;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleNumber() {
        return roleNumber;
    }

    public void setRoleNumber(String roleNumber) {
        this.roleNumber = roleNumber;
    }

    public String getRoleCon() {
        return roleCon;
    }

    public void setRoleCon(String roleCon) {
        this.roleCon = roleCon;
    }
}
