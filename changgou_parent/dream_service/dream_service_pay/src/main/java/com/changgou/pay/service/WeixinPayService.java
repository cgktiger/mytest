package com.changgou.pay.service;

import java.util.Map;

public interface WeixinPayService {
	
	//统一下单  生成支付的url  二维码
	public Map createNative(String out_trade_no,String total_fee);
	
	//查询订单
	public Map queryPayStatus(String out_trade_no);
}
