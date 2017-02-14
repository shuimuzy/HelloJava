package com.samples.pattern;

/**
 * 
 * @author shuimu.tian
 *
 * Singleton pattern
 * 静态内部类单例模式
 */
		
public class Singleton {
	
	private static final Singleton INSTANCE = new Singleton();  
	
	 private Singleton (){
	    }  

	    public static final Singleton getInstance() {  
	          return Singleton.INSTANCE;  
	    }  

}
