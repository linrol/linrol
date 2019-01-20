package com.linrol.rollin.test;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月10日 上午10:18:21 
* 双重校验锁 
*/
public class SignletonDoubleCheck {

	private static SignletonDoubleCheck instence;
	private SignletonDoubleCheck(){
	};
	public static SignletonDoubleCheck getInstence(){
		if(instence == null){
			synchronized (SignletonDoubleCheck.class) {
				if(instence == null){
					instence = new SignletonDoubleCheck();
				}
			}
		}
		return instence;
	}
}
