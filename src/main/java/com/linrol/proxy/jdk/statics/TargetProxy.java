package com.linrol.proxy.jdk.statics;

/**
 * 代理对象
 * @author linrol
 *
 */
public class TargetProxy implements Target {
	// 实现被代理对象同样的接口

	// 传入被代理对象，实现对被代理对象的代理
	private Target target;
	
	public TargetProxy(Target target) {
		// 通过构造方法将被代理对象传入并赋值给代理类
		this.target = target;
	}
	
	// 对被代理对象实现具体的代理方法
	@Override
	public void say() {
		System.out.println("说话前先思考一下");
		target.say();
		System.out.println("说完话后总结一下");
	}

}
