package com.linrol.rollin.alg;

/** 
* @author 罗林 E-mail:188837541249@163.com 
* @version 创建时间：2017年7月18日 下午5:49:29 
* 类说明 
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PurchaseOrderMain {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	while(in.hasNext()){
    		int a = 0 , b = 0;
    		int n = in.nextInt();
    		int m = in.nextInt();
    		List<Integer> nList = new ArrayList<Integer>();
    		Map<String,Integer> mList = new HashMap<String,Integer>();
    		List<Integer> mBkList = new ArrayList<Integer>();
    		for(int i = 0; i < n; i++){
    			nList.add(in.nextInt());
    		}
    		for(int i = 0; i < m; i++){
    			String goods = in.next();
    			if(mList.get(goods) == null){
    				mList.put(goods, mList.size());
    				mBkList.add(1);
    			}else{
    				int index = mList.get(goods);
    				mBkList.set(index, mBkList.get(index)+1);
    			}
    		}
    		Collections.sort(nList);
    		Collections.sort(mBkList);
    		for(int i = 0;i<mList.size();i++){
    			a += nList.get(i) * mBkList.get(mBkList.size() - i -1);
    			b += nList.get(nList.size() - i - 1) * mBkList.get(mBkList.size() - i -1);
    		}
    		System.out.println(a+" "+b);
    	}
    	in.close();
    }
}