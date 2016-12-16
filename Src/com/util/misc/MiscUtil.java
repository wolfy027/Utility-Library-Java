package com.util.misc;

public abstract class MiscUtil {
	private MiscUtil(){}
	
	/**
	 * returns the sum of special series
	 * 
	 * @param x
	 * @param numTerms
	 * @return
	 */
	public static double sumOfSeries(double x, int numTerms) {
		double sum = x;
		int ctr = 1;
		if (numTerms > 1)
			for (int i = 3; ctr < numTerms; ctr++, i += 2) {
				sum += (Math.pow(x, i) / i) * getPrefix(i);
			}
		return sum;
	}

	/**
	 * returns the prefix required for the special series utility method
	 * 
	 * @param num
	 * @return
	 */
	public static double getPrefix(int num) {
		double prefix = 1;
		if (num == 1)
			return prefix;
		for (int i = 1; i < num; i++) {
			if (i % 2 == 0) {
				prefix /= i;
			} else {
				prefix *= i;
			}
		}
		return prefix;
	}

}
