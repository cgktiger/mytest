package com.changgou.goods.dao;

import com.changgou.goods.pojo.Spec;
import feign.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SpecMapper extends Mapper<Spec>{


    //根据商品分类名称查询规格列表
    @Select("select name,options from tb_spec where template_id = " +
            "(select template_id from tb_category where name = #{name}) order by seq")
    public List<Map> findMapByCategoryName(@Param("name") String name);


}
