package com.linrol.proxy.jdk.statics;

public class StaticProxyTest {

	public static void main(String[] args) {
		//new一个被代理对象传给代理对象,建立代理关系
		Target targetProxy = new TargetProxy(new TargetImpl());
		//执行代理方法
		targetProxy.say();
		//总结:静态代理需要实现接口才能完成，并且针对不同的被代理对象需要创建不同的代理类，不易扩展且后期不易维护
	}
}
