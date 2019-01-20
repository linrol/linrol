package com.linrol.proxy.jdk.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 代理工厂类
public class ProxyFactory {

	/**
	 * 通过Proxy生产代理对象
	 * @param target 被代理对象
	 * @return
	 */
	public static Object makeProxyInstance(Object target){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
			// 事件处理器,当执行被代理对象的方法时会触发事件处理器的invoke方法,并把被代理对象和执行的方法传入,然后通过反射调用被代理对象的方法
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("说话前多维度考虑一下");
				Object methodReturn = method.invoke(target, args);
				System.out.println("学会总结与反思");
				return methodReturn;
			}
		});
	}
}
