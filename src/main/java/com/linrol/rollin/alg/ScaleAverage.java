package com.linrol.rollin.alg;

import java.util.Scanner;

/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年7月21日 下午3:42:27 
* 类说明 
*/
public class ScaleAverage {
	
	public int a = 3;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int scaleCount = 0;
    		StringBuffer scaleStr = new StringBuffer();
    		int A = in.nextInt();
    		for(int i = 2;i<A;i++){
    			String str = Integer.toString(A, i);
    			System.out.println(str);
    			scaleStr.append(str);
    		}
    		for(int j = 0;j<scaleStr.length();j++){
    			char c = scaleStr.charAt(j);
    			if(Character.isDigit(c)){
    				scaleCount += Integer.parseInt(String.valueOf(c));
    			}else{
    				scaleCount += ((int)c - 96);
    			};
				
			}
    		System.out.println(scaleCount+"/"+(A-2));
    	}
    	in.close();
	}
}
