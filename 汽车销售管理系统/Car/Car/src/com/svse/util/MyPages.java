package com.svse.util;

public class MyPages {
	
	public int getAllpages(int count,int everpage){
		int a =count%everpage;
		int allpages=0;
		if(a==0){
			if(count==0){
				allpages=1;
			}else{
				allpages=count/everpage;
			}
		}else{
			allpages=count/everpage+1;
		}
		return allpages;
	}
	
	public int getUp(int begin){
		int up=begin-1;
		if(up<1){
			up=1;
		}
		return up;
	}
	
	public int getNext(int begin,int allpages){
		int next=begin+1;
		if(next>allpages){
			next=allpages;
		}
		return next;
	}
}
