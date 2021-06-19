package com.changgou.system.service.impl;

import com.changgou.goods.pojo.Admin;
import com.changgou.system.dao.AdminMapper;
import com.changgou.system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
class AdminServiceImpl implements AdminService {

    //注入mapper
    @Autowired
    private AdminMapper adminMapper;


    @Override
    public boolean login(Admin admin) {

        //根据admin中的用户名称  查询对应的用户信息
        /*Example example = new Example(Admin.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("login_name",admin.getLogin_name());

        List<Admin> adminsList = adminMapper.selectByExample(example);


        if(adminsList.get(0) != null){

            //判断
            if(BCrypt.checkpw(admin.getPassword(),adminsList.get(0).getPassword())){

                return   true;
            }else{

                return false;
            }

        }
           return  false;
        */
        Admin admin1=new Admin();
        admin1.setLogin_name(admin.getLogin_name());
        admin1.setStatus("1");
        Admin admin2 = adminMapper.selectOne(admin1);//数据库查询出的对象
        if(admin2==null){
            return false;
        }else{
            //验证密码, Bcrypt为spring的包, 第一个参数为明文密码, 第二个参数为密文密码
            return BCrypt.checkpw(admin.getPassword(),admin2.getPassword());
        }


    }

    @Override
    public void add(Admin admin) {

        //使用bcrypt加密密码
        String gensalt = BCrypt.gensalt();

        String bcyptPassword = BCrypt.hashpw(admin.getPassword(), gensalt);

        admin.setPassword(bcyptPassword);

        //添加数据
        adminMapper.insert(admin);

    }
}
