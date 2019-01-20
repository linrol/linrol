package com.linrol.rollin.test;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月10日 上午10:10:56 
* 懒汉单例，线程安全，效率很低
*/
public class SignletonLazyThreadSafe {

	private static SignletonLazyThreadSafe instence;
	private SignletonLazyThreadSafe(){
	};
	public static synchronized SignletonLazyThreadSafe getInstence(){
		if(instence == null){
			instence = new SignletonLazyThreadSafe();
		}
		return instence;
	}
}
