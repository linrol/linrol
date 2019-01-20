package com.linrol.rollin.controller;

import foryou.core.annotation.ClassMapingUrl;
import foryou.core.base.BaseController;

/**
 * @author 罗林 E-mail:1071893649@qq.com
 * @version 创建时间：2017年6月22日 上午2:56:59 类说明
 */
@ClassMapingUrl
public class TestController extends BaseController {

	public String property1;

	public String property2;

	public String testMethod() {
		System.out.println("property1=" + property1 + ",property2=" + property2);
		return "The Request Controller:TestController,Method:testMethod.property1=" + property1 + " and property2=" + property2;
	}
}
