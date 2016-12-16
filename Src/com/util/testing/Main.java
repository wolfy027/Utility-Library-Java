package com.util.testing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void pattern1(int num) {
		for (int i = 64; i<70; i++) {
			for (int j = 64,k=70; j<=i; j++) {
				System.out.print((char)(k-i+j));

			}
			System.out.println();
		}

	}
	
	public static String stringYak(String str) {
		  return str.replaceAll("yak", "");  
		}

	/**
	 * @param args
	 */
	//public static void main(String[] args) {	
		//System.out.println(stringYak("yakxxxyak"));
		//System.out.println(SystemInfoUtil.getSystemBitType());
		//System.out.println(StringUtil.reverseString2("123456789"));
		/*
		 * System.out.println(ConversionUtil.fromDecimal("55998", 16));
		 * ArrayUtil.printArray(new int[]{44,55,66,77,88,99,11,22,33,44});
		 * System.out.println(ArrayUtil.removeElement(new
		 * int[]{44,55,66,77,88,99,11,22,33,44}, 44));
		 */
		/* System.out.println(ArithmeticUtil.isPrime(22)); */
		/*
		 * int[] arr={1,4,1,3,2,1,3,1,1,7}; ArrayUtil.printArray(arr);
		 * ArrayUtil.reverseArray(arr); ArrayUtil.printArray(arr);
		 */
		// System.out.println(StringUtil.reverseString("asdf"));;
		// TwoDArrayUtil.printArray(new int[][]{{1,2,5},{67,2,32}});
		// System.out.println(TwoDArrayUtil.isEquiDimensional(new
		// int[][]{{1,2,5},{67,2,32}},new int[][]{{1,2,5},{67,2,32}}));
		/*
		 * int [][] x=new int[][]{{1,0,0,0},{0,1,0,0},{0,0,0,1}}; int [][] y=new
		 * int[][]{{1,0,0},{0,1,0},{0,0,0},{1,1,1}};
		 * TwoDArrayUtil.printArray(x); TwoDArrayUtil.printArray(y);
		 * TwoDArrayUtil.printArray(TwoDArrayUtil.multiply(x, y));
		 */
		// PatternUtil.diamond();
		// System.out.println(FormatUtil.get2Decimals("2.1"));;
		//pattern1(5);
		/*Double b1=new Double("2");
		Double b2=new Double("1.1");
		System.out.println( );*/
		
/*		System.out.println(CharUtil.isSpace('\n'));
		System.out.println(CharUtil.isConsonant('g'));
		System.out.println(CharUtil.isPunctuation('2'));*/
	//	System.out.println(System.getProperty("user.home")+ File.separator+"Downloads"+File.separator+"Download.csv");
		
	//	String s1="Prince";
	//	s1.concat("Gupta");		
	//	System.out.println(s1);
		
		
		
	//}
		public static void main(String args[]) throws IOException
        {
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer reader;
                reader = new StringTokenizer (stdin.readLine());
                int count =1;
                String temp;
                while (count <=10)
                {
                        while(reader.countTokens() == 0)
                                reader = new StringTokenizer(stdin.readLine());
                        temp = reader.nextToken();
                        if (temp.equals("+"))
                        {
                         }
                        else
                        {
                        System.out.println ("hi");
                        }
                        //System.out.println(reader.nextToken());
                        count = count + 1;
                }
        }

}
