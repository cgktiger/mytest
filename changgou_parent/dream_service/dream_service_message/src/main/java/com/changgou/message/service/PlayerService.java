package com.changgou.message.service;


import com.changgou.message.pojo.Player;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface PlayerService {

    //测试
    public String findTest();


    //查询全部
    public List<Player> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Player findById(Integer id);

    /***
     * 新增品牌
     * @param Player
     */
    public void add(Player brand);

    /***
     * 修改品牌数据
     * @param Player
     */
    public void update(Player brand);
    /***
     * 删除品牌
     * @param id
     */
    public void delete(Integer id);
    /***
     * 多条件搜索品牌方法
     * @param searchMap
     * @return
     */
    public List<Player> findListByMap(Map<String, Object> searchMap);

    /***
     * 多条件分页查询
     * @param searchMap
     * @param page
     * @param size
     * @return
     */
    Page<Player> findPage(Map<String, Object> searchMap, int page, int size);
}
