package com.zpl.day03.t4;

import java.util.concurrent.TimeUnit;

public class MainParent {
	public int i=10;
	public void operateIMainParentMethod(){
		i--;
		System.err.println("parent print i="+i);
		try {
			TimeUnit.SECONDS.sleep(3);//Ë¯3Ãë
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
