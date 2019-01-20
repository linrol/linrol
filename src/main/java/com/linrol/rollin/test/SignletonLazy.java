package com.linrol.rollin.test;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月10日 上午10:07:30 
* 懒汉单例，非线程安全
*/
public class SignletonLazy {
	private static SignletonLazy instence;
	private SignletonLazy(){
	};
	public static SignletonLazy getInstence(){
		if(instence == null){
			instence = new SignletonLazy();
		}
		return instence;
	}
}
