package com.linrol.rollin.test;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月10日 上午10:00:36 
* 类说明 
*/
public class TestSignleton {

	public static void main(String[] args) {
		Signleton instenceA = Signleton.getInstence();
		Signleton instenceB = Signleton.getInstence();
		System.out.println(instenceA == instenceB);
	}
}
