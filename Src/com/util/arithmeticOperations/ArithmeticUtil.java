package com.util.arithmeticOperations;

public abstract class ArithmeticUtil {

	private ArithmeticUtil() {

	}

	/**
	 * swaps the values in the integer variables passed as arguments
	 * 
	 * @param x
	 * @return
	 */
	public static void swapNumbers(int x, int y) {
		x = x ^ y;
		y = x ^ y;
		x = y ^ x;
	}
	
	
	/**
	 * GETS THE HIGHEST  COMMON FACTOR AMONGST A AND B.
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a,int b){		
		while (b != 0) {
			   int temp = b;
			   b = a % b;
			   a = temp;
			}
		return a;
	}

	/**
	 * checks if the argument passed is a perfect sqaure
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPerfectSquare(int n) {

		for (int i = 1; i < n / 2; i++)
			if (n / i == i)
				return true;

		return false;

	}

	/**
	 * checks if the argument passed is a prime number
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		int ctr = 0;
		for (int i = 2; i <= x/2; i++) {
			if (x % i == 0)
				ctr++;
		}
		if (ctr == 2)
			return true;
		return false;

	}
	/**
	 * returns the cube of a number
	 * @param c
	 * @return
	 */
	public static int cube(int c){
		return (c*c*c);
	}

	/**
	 * checks if the argument passed is an armstrong number
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isArmstrongNumber(String num) {
		int sum=0;
		for(char c:num.toCharArray()){
			sum+=cube((int)c);
		}
		return String.valueOf(sum).equals(num);
	}

	/**
	 * reverses the digits of the integer argument passed
	 * 
	 * @param input
	 *            parameter to be reversed
	 * @return reversed form of number
	 */
	public static int reverseNumeral(int n) {
		int reverse = 0;
		int rem = 0;

		while (n != 0) {
			rem = n % 10;
			reverse = reverse * 10 + rem;
			n = n / 10;
		}
		return reverse;
	}

	/**
	 * returns the sum of variable number of integer arguments passed.
	 * 
	 * @param i
	 * @return
	 */
	public static int getSum(int... i) {
		if (i.length < 0)
			return 0;
		int sum = 0;
		for (int j = 0; j < i.length; j++)
			sum += i[j];
		return sum;
	}
}
