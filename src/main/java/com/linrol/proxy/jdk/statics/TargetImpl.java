package com.linrol.proxy.jdk.statics;

/**
 * 被代理对象
 * @author linrol
 *
 */
public class TargetImpl implements Target {

	/**
	 * 被代理方法
	 */
	@Override
	public void say() {
		System.out.println("我要说话");
	}

}
