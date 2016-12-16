package com.util.singleton;

public class MySingleton {
 
	private static MySingleton instance = null;
 
	protected MySingleton() {
	}
 
	
	public static MySingleton getInstance() {
		if (instance == null) {
			synchronized (MySingleton.class) {
				if (instance == null) {
					instance = new MySingleton();
				}
			}
		}
		return instance;
	}
}