package com.zpl.day02.more;

import java.util.concurrent.TimeUnit;

public class HasselfPrivateNums {

	private int count=0;
	
	public void addI(String username){
		if(username.equals("a")){
			count=100;
			System.out.println("a set count");
			/*try {
				//TimeUnit.SECONDS.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}else{
			count=200;
			System.out.println("b set count");
		}
		System.out.println(username+" count="+count);
	}
}
