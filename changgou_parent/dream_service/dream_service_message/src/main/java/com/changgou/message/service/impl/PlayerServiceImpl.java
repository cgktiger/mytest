package com.changgou.message.service.impl;


import com.changgou.message.dao.PlayerMapper;
import com.changgou.message.pojo.Player;
import com.changgou.message.service.PlayerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PlayerServiceImpl implements PlayerService {

    //注入mapper
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public String findTest() {
        return "helloWorld";
    }

    @Override
    public List<Player> findAll() {

        return playerMapper.selectAll();
    }

    @Override
    public Player findById(Integer id) {
        return playerMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Player player) {
        playerMapper.insert(player);
    }

    @Override
    public void update(Player player) {
        playerMapper.updateByPrimaryKeySelective(player);
    }
    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        playerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Player> findListByMap(Map<String, Object> searchMap) {
        Example example=new Example(Player.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 品牌名称
            if(searchMap.get("playerName")!=null && !"".equals(searchMap.get("playerName"))){
                criteria.andLike("playerName","%"+searchMap.get("playerName")+"%");
            }
            // 品牌名称
            if(searchMap.get("playerSex")!=null && !"".equals(searchMap.get("playerSex"))){
                criteria.andLike("playerSex","%"+searchMap.get("playerSex")+"%");
            }
            // 品牌名称
            if(searchMap.get("playerRole")!=null && !"".equals(searchMap.get("playerRole"))){
                criteria.andLike("playerRole","%"+searchMap.get("playerRole")+"%");
            }
        }
        return playerMapper.selectByExample(example);
    }

    @Override
    public Page<Player> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page,size);
        Example example=new Example(Player.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // 名称
            if(searchMap.get("playerName")!=null && !"".equals(searchMap.get("playerName"))){
                criteria.andLike("playerName","%"+searchMap.get("playerName")+"%");
            }
            // 艺名
            if(searchMap.get("playerStage")!=null && !"".equals(searchMap.get("playerStage"))) {
                criteria.andLike("playerStage", "%" + searchMap.get("playerStage") + "%");
            }
            // 编号
            if(searchMap.get("playerSerial")!=null && !"".equals(searchMap.get("playerSerial"))){
                criteria.andEqualTo("playerSerial",searchMap.get("playerSerial"));
            }
        }
        Page<Player> pageBean  = ( Page<Player>)playerMapper.selectByExample(example);

        return pageBean;
    }


}
