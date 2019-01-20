package com.linrol.proxy.jdk.dynamic;

public class DynamicProxyTest {

	public static void main(String[] args) {
		//new一个被代理对象传给代理工厂类的产生代理类的方法,建立代理关系
		Target target = (Target) ProxyFactory.makeProxyInstance(new TargetImpl());
		//执行被代理的方法
		target.say();
		//总结:静态代理需要实现接口才能完成，并且针对不同的被代理对象需要创建不同的代理类，不易扩展且后期不易维护
	}
}
