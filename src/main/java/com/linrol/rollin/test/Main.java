package com.linrol.rollin.test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// int N;
		// N = Integer.valueOf(in.nextLine());

		while (in.hasNext()) {
			// initialize the value of input
			in.nextLine();
			String str1 = in.nextLine();
			String str2 = in.nextLine();
			List<String> a = new ArrayList<>(Arrays.asList(str1.split(" ")));
			List<String> b = new ArrayList<>(Arrays.asList(str2.split(" ")));
			List<Integer> c = new ArrayList<Integer>();
			a.addAll(b);
			for(String s:a){
				if(!c.contains(Integer.parseInt(s))){
					c.add(Integer.parseInt(s));
				}
			}
			Collections.sort(c);
			for(Integer i:c){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		in.close();
	}
}