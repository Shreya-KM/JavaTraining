package com.training.singletonapp;

public class Single {
	private int num;
	
	private static Single single;
//	private static int count;
	
	private Single() {
//		count++;
	}
	
	public static Single getInstance() {
//		if(count==0) {
		if(single==null) {
			single=new Single();
		}
		return single;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
}
