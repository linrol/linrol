package com.linrol.rollin.alg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/** 
* @author 罗林 E-mail:1071893649@qq.com 
* @version 创建时间：2017年8月22日 下午7:21:53 
* 类说明 
*/
public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> xList = new ArrayList<Integer>();
		List<Integer> yList = new ArrayList<Integer>();
		Map<Integer,Integer> xyMap = new HashMap<Integer,Integer>();
		for(int i=0;i<N;i++){
			int X = in.nextInt();
			int Y = in.nextInt();
			xList.add(X);
			yList.add(Y);
			xyMap.put(X, Y);
		}
		Collections.sort(xList);
		Collections.sort(yList);
		for(int i = 0;i<xList.size();i++){
			if(xyMap.get(xList.get(i)) == yList.get(yList.size()-1)){
				System.out.println(xList.get(i)+" " +xyMap.get(xList.get(i)));
			}
			yList.remove(xyMap.get(xList.get(i)));
		}
    	in.close();
	}
}