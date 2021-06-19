package com.changgou.pay.controller;

import java.util.HashMap;
import java.util.Map;


import com.changgou.entity.Result;
import com.changgou.pay.service.WeixinPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 支付控制层
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/pay")
public class PayController {
	
	
	/**
	 * 生成二维码
	 * @return
	 */
	@Autowired
	private WeixinPayService weixinPayService;
	

	
	
	
	//统一下单  生成支付的url
	@RequestMapping("/createJsapi.do")
	public Map createNative(@RequestParam Map maps){

		
		Map map = null;

		System.out.println(maps);

		//map = weixinPayService.createNative(payLog.getOutTradeNo(), payLog.getTotalFee()+"");
		map = weixinPayService.createNative((String) maps.get("out_trade_no"), 1+"");



		return map;
	}
	
	
	//查询订单支付结果
	@RequestMapping("/queryPayStatus.do")
	public Result queryPayStatus(String out_trade_no){
		
		int count=0;
		
		while(true){
			
			count++;
			
			Map map = weixinPayService.queryPayStatus(out_trade_no);
			
			//判断
			if (map == null) {
				return new Result(false, "您的网络有问题!");

			}
			
			System.out.println("map:=========="+map);
			if (map!= null && "SUCCESS".equals(map.get("trade_state"))) {
				
				System.out.println("支付成功===============================");
				

				
				
				return new Result(true, "支付成功");
			}
			
			
			//每隔5秒查询一次用户的支付结果
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			
			
			//判断 定时器
			if (count >= 180) {   //180秒内没有付款
				return new Result(false, "付款超时!");
			}
			
		}
		
	}
}
