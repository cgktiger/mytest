package com.changgou.message.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;

import com.changgou.message.pojo.Player;
import com.changgou.message.service.PlayerService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    //测试
    @RequestMapping("/findTest.do")
    public String findTest(){

        System.out.println("访问了吗~");

        return playerService.findTest();
    }


    //查询全部
    @RequestMapping("/findAll.do")
    public Result findAll(){
        List<Player> brandList = playerService.findAll();
        return  new Result(true,200,"查询成功",brandList);
    }


    //根据id查询
   // @GetMapping
    @RequestMapping("/findById.do/{id}")   //基于 restful 访问格式的http请求
    public Result findById(@PathVariable int id){
        Player player = playerService.findById(id);
        return  new Result(true,200,"查询成功",player);
    }


    //添加brand
    @RequestMapping("/insert.do")   //基于 restful 访问格式的http请求
    //@PostMapping
    public Result add(@RequestBody Player player,MultipartFile file){   //将接受的json串   转成pojo类 , 封装到   brand中

        try{

            playerService.add(player);

            return  new Result(true, StatusCode.OK, "添加成功");

        }catch (Exception e){


            return  new Result(true, StatusCode.ERROR, "添加失败");
        }






    }
    //修改
// @PutMapping
    @RequestMapping("/update.do/{id}")   //基于 restful 访问格式的http请求
    public Result update(@PathVariable int id,@RequestBody Player player){
        //设置id
        player.setId(Long.valueOf(id));
        playerService.update(player);
        return  new Result(true,200,"修改成功");
    }



    //根据id删除
//  @PutMapping
    @RequestMapping("/delete.do/{id}")   //基于 restful 访问格式的http请求
    public Result update(@PathVariable int id){
        playerService.delete(id);
        return  new Result(true,200,"删除成功");
    }


    @RequestMapping("/findListByMap.do")   //基于 restful 访问格式的http请求
    public Result findListByMap(@RequestParam Map searchMap){
        List<Player> list = playerService.findListByMap(searchMap);
        return  new Result(true,200,"查询成功",list);
    }

    @RequestMapping("/findPage.do/{page}/{size}")   //基于 restful 访问格式的http请求
    public Result findPage(@RequestParam Map searchMap,@PathVariable int page,@PathVariable int size){
        Page pageBean = playerService.findPage(searchMap, page, size);
        return  new Result(true,200,"查询成功",pageBean.getResult());
    }

}
