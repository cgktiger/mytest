package com.changgou.pay.service.impl;

import java.util.HashMap;
import java.util.Map;


import com.changgou.pay.service.WeixinPayService;
import com.changgou.utils.HttpClient;
import com.changgou.utils.NativePayConfig;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.stereotype.Service;


@Service
public class WeixinPayServiceImpl implements WeixinPayService {
	
	////统一下单  生成支付的url  二维码
	@Override
	public Map createNative(String out_trade_no, String total_fee) {
		
		//创建微信支付对象
		//一.拼接参数
		//1.创建参数
		Map<String,String> param=new HashMap<>();//创建参数
		//公众号
		param.put("appid", NativePayConfig.appid);
		//商户id
		param.put("mch_id", NativePayConfig.partner);//商户号
		//随机字符串
		param.put("nonce_str", WXPayUtil.generateNonceStr());
		//商品描述
		param.put("body", "测试数据");//商品描述
		//商户订单号
		param.put("out_trade_no", out_trade_no);
		//总金额（分）
		param.put("total_fee",total_fee);
		//IP
		param.put("spbill_create_ip", "127.0.0.1");
		//回调地址(随便写)
		param.put("notify_url",NativePayConfig.notifyurl);
		//交易类型
		param.put("trade_type", "JSAPI");
		param.put("openid",NativePayConfig.openid);//用户的openid，自己获取
		try {
			//自动添加 签名 并生成 发送的xml
			String signedXml = WXPayUtil.generateSignedXml(param, NativePayConfig.partnerkey);
			
			
			//二.使用httpClient想微信 服务器   发送请求   统一下单   url
			System.out.println("signedXml: " + signedXml +"==================================");	
			HttpClient client=new HttpClient("https://api.mch.weixin.qq.com/pay/unifiedorder");
			
			client.setHttps(true);
			client.setXmlParam(signedXml);
			//发送请求
			client.post();
			
			
			//三.处理响应结果
			//3.获得结果 
			String result_str = client.getContent();
			System.out.println("响应结果: " + result_str);   //xml形式的 字符串
			
			//转成map集合形式
			Map<String, String> resultMap = WXPayUtil.xmlToMap(result_str);
			
			
			/*//创建一个响应的  map  集合
			Map<String, String> result = new HashMap<>();
			
			//设置响应参数
			result.put("out_trade_no", out_trade_no);
			result.put("total_fee", total_fee);
			result.put("code_url", resultMap.get("code_url"));
			
			return result;*/
			Map<String, String> map=new HashMap<>();
			Map<String, String> reqData=new HashMap<>();

			String timeStamp = "" + (System.currentTimeMillis() / 1000);
			map.put("timeStamp", timeStamp);	//时间戳
			map.put("nonceStr",resultMap.get("nonce_str"));//随机字符串
			map.put("package",resultMap.get("prepay_id")+"");//拼接package返回给前端
			map.put("signType","MD5");//签名类型
			map.put("prepay_id",resultMap.get("prepay_id"));//预支付订单id

			//小程序支付需要二次签名  注意这里的appId的I字母是大写
			reqData.put("appId",NativePayConfig.appid);//二次签名所用的参数
			reqData.put("timeStamp",timeStamp); //时间戳
			reqData.put("nonceStr",resultMap.get("nonce_str"));//随机字符串
			reqData.put("package","prepay_id="+resultMap.get("prepay_id"));//拼接package
			reqData.put("signType","MD5");	//签名类型
			//partnerkey是商户秘钥
			map.put("paySign", WXPayUtil.generateSignature(reqData, NativePayConfig.partnerkey));
			return map;

			
		} catch (Exception e) {
			e.printStackTrace();
			//return null;
			return new HashMap<>();
		}
		
	}
	
	
	
	//查询订单   是否支付成功
	@Override
	public Map queryPayStatus(String out_trade_no) {
		
		try {
			Map param=new HashMap();
			param.put("appid", NativePayConfig.appid);//公众账号ID
			param.put("mch_id", NativePayConfig.partner);//商户号
			param.put("out_trade_no", out_trade_no);//订单号
			param.put("nonce_str", WXPayUtil.generateNonceStr());//随机字符串
			String url="https://api.mch.weixin.qq.com/pay/orderquery";		
			
			
			String xmlParam = WXPayUtil.generateSignedXml(param, NativePayConfig.partnerkey);
			HttpClient client=new HttpClient(url);
			client.setHttps(true);
			client.setXmlParam(xmlParam);
			client.post();
			String result_str = client.getContent();			
			System.out.println("================================================");
			System.out.println("查询支付的结果: " + result_str );
			
			//转成map集合形式
			Map<String, String> resultMap = WXPayUtil.xmlToMap(result_str);
			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		
	}

		
}
