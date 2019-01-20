package com.linrol.rollin.alg;
/*package com.rollin.alg;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

*//**
 * @author 罗林 E-mail:1071893649@qq.com
 * @version 创建时间：2017年10月17日 下午8:15:05 类说明
 *//*
public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int iSum = 0;
		int n = in.nextInt();
		int x = in.nextInt();
		Map<Integer, Integer> nMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			nMap.put(i, in.nextInt());
		}
		for (int i = x - 1;;) {
			if (nMap.get(i) - 1 == -1) {
				nMap.put(i, iSum);
				break;
			}
			nMap.put(i, nMap.get(i) - 1);
			if (--i < 0) {
				i = n - 1;
			}
			iSum++;
		}
		for (int j = 0; j < nMap.size(); j++) {
			System.out.print(nMap.get(j) + " ");
		}
	}
}
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int iSum = 0;
	    int n = in.nextInt();
	    int x = in.nextInt();
	    Map<Integer, Integer> nMap = new HashMap<Integer, Integer>();
	    for (int i = 0; i < n; i++) {
            nMap.put(i, in.nextInt());
        }
		for (int i = x - 1;;) {
			if (nMap.get(i) - 1 == -1) {
				nMap.put(i, iSum);
				break;
			}
			nMap.put(i, nMap.get(i) - 1);
			/*System.out.println(i+"..."+nMap.get(i));*/
			if (--i < 0) {
				i = n - 1;
			}
			iSum++;
		}
		for (int j = 0; j < nMap.size(); j++) {
			System.out.print(nMap.get(j) + " ");
		}
	}
}