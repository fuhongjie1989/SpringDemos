package com.zpl.day03.t4;

import java.util.concurrent.TimeUnit;

public class SubMain extends MainParent {

	public void operateISubMethod(){
		while(i>0){
			i--;
			System.out.println("sub print i="+i);
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.operateIMainParentMethod();//这里的super和this有什么区别
		}
	}
}
