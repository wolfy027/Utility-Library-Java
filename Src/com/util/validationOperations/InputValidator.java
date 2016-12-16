package com.util.validationOperations;

public abstract class InputValidator {	
	private InputValidator() {}
	
	public static boolean isString(String s){
		if(s.matches("[A-Za-z0-9 ]+")){					//"[A-Za-z0-9 ]" for single input
			return true;								//"[A-Za-z0-9 ]+" for multiple input
		}												//"[A-Za-z0-9 ]{3}" for three input
		return false;	 								//"[A-Za-z0-9 ]{3,5}" for three to five input
	}													//[X]+ X occure 1 or more times
														//[X]* X occure 0 or more times
	public static boolean isChar(String cha){			//[X]{1} X occure only times
		if(cha.matches("[A-Za-z0-9 ]{1}")){				//[X]{1,2} X can occure one to two times
			return true;
		}
		return false;
	}

	public static boolean isWord(String str){
		if(str.matches("[A-Za-z]+")){
			return true;
		}
		return false;
	}
	
	public static boolean isBinaryNumber(String str){
		 if(str.matches("[0-1]+")){
			 return true;
		 }
		return false;
	 }

	public static boolean isNumber(String str){
		if(str.matches("[0-9]+")){                     
			return true;								
		}
		return false;	 
	}
	
	public static boolean isOctalNumber(String str){
		 if(str.matches("[0-7]+")){
			 return true;
		 }
		return false;
	 }
	
	public static boolean isHexaNumber(String str){
		 if(str.matches("[0-9a-fA-F]+")){
			 return true;
		 }
		return false;
	 }	
	public static boolean lineValidator(String line){
		if(line.matches("[0-9,]+"))
			return true;
		
		return false;		
	}
	
	public static boolean isDoubleOrNumber(String str){
		try{Double.valueOf(str);}catch(NumberFormatException e){return false;}
		return true;	 
	}
	
	/*public static boolean isEmail(String str){
		 if(str.matches("[a-zA-Z0-9]+")){
			 return true;
		 }
		return false;
	 }*/
	
	
}
