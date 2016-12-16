package com.util.formatOperations;

import java.text.DecimalFormat;

public class FormatUtil {
	private FormatUtil(){}
	
	public static double get2Decimals(String num){		
		DecimalFormat df=new DecimalFormat(".##");		
		return Double.valueOf(df.format((Double.valueOf(num))));	
	}
	

}
