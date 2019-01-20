package com.linrol.rollin.test;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月10日 上午9:59:57 
* 饿汉单例模式
*/
public class Signleton {
	private static Signleton instence = new Signleton();
	private Signleton(){
	}
	public static Signleton getInstence(){
		return instence;
	}
}
