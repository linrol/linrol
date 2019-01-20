package com.linrol.rollin.alg;
/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2018年2月8日 下午4:08:13 
* 类说明 
*/
public class Main3 {

	public static void main(String[] args) {
		System.out.println("ll".hashCode());
		String a= new String("132");
		Object b = new Object();
		b = "132";
		ScaleAverage s = new ScaleAverage();
		s.a = 10;
		System.out.println(s.hashCode() + "..." + s.hashCode());
		String c = "123";
		String d = "123";
		System.out.println(c.hashCode() + "..." + d.hashCode());
	}
}
