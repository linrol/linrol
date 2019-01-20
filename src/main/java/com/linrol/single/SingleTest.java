package com.linrol.single;

public class SingleTest {

	private static SingleTest single;
	
	private SingleTest(){
	}
	
	public static SingleTest getSingle(){
		if(single != null) {
			synchronized(SingleTest.class) {
				if(single != null) {
					single = new SingleTest();
				}
			}
		}
		return single;
	}
}


