package com.linrol.rollin.alg;

import java.math.BigInteger;
/** 
* @author 罗林 E-mail:18883754124@qq.com 
* @version 创建时间：2017年8月12日 下午3:34:24 
* 类说明 
*/
import java.util.Scanner;

public class Main4 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {// 注意while处理多个case
			BigInteger x = in.nextBigInteger();
			BigInteger f = in.nextBigInteger();
			BigInteger d = in.nextBigInteger();
			BigInteger p = in.nextBigInteger();
			System.out.println((d.add(f.multiply(p))).divide((x.add(p))));
		}

	}
}