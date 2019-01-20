package com.linrol.algorithm.dg;

public class QuickSort {

	public static void main(String[] args) {
		int s[] = {6,3,4,8,12,10,0,1,3,5,3,7,9};
		quickSort(s, 0, s.length-1);
		for(int i=0;i<s.length;i++){
			System.out.print(s[i] +" ");
		}
	}
	
	public static void quickSort(int s[],int l,int r){
		if(l<r){
			int i=l,j=r,x=s[l];
			while(i<j){
				while(i<j && s[j]>=x){
					j--;
				}
				if(i<j){
					s[i++] = s[j];
				}
				while(i<j && s[i]<x){
					i++;
				}
				if(i<j){
					s[j--] = s[i];
				}
			}
			s[i] = x;
			quickSort(s, l, i-1);
			quickSort(s, i+1, r);
		}
	}
	
}
