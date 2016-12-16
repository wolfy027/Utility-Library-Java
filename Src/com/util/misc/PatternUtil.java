package com.util.misc;

public class PatternUtil {
	private PatternUtil(){}
	
	public static  void diamond(){
		System.out.println("Enter the size:- ");
		int s = 10;
		int nos = s-2;
		for (int i = 0; i < s; i++){
		for (int l = nos; l >= 0; l--)
		{System.out.print(" ");}
		for (int k = 0; k <= i; k++)
		{System.out.print("*"); }
		for (int k = 1; k <= i; k++)
		{System.out.print("$");}
		nos--;
		System.out.print("\n");
		
		}
		for (int i = s-2; i >= 0; i--)
		{
			for (int l = -2; l <= nos; l++)
		{System.out.print(" ");}
		for (int k = i; k >= 0; k--)
		{System.out.print("!");}
		for (int k = 1; k <= i; k++)
		{System.out.print("*");}
		nos++;
		System.out.print("\n");
		}
		
	}

}
