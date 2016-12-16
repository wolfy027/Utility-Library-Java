package com.util.arrayOperations;

import com.util.arithmeticOperations.ArithmeticUtil;

public abstract class ArrayUtil {

	private ArrayUtil() {
	}

	/**
	 * returns the sum of the diagonal elements aligned from top left to bottom
	 * right corner of the square two dimensional array passed
	 * 
	 * @param arr
	 * @return
	 */
	public static int getsumdiagonal1(int[] arr) {
		if (!ArithmeticUtil.isPerfectSquare(arr.length))
			return 0;

		int sum = 0;
		int root = (int) Math.sqrt(arr.length);
		for (int i = 0; i < root; i++) {
			sum += arr[(i * root) + (i)];
		}
		return sum;
	}

	/**
	 * returns the sum of the diagonal elements aligned from top right to bottom
	 * left corner of the square two dimensional array passed
	 * 
	 * @param arr
	 * @return
	 */
	public static int getsumdiagonal2(int[] arr) {
		if (!ArithmeticUtil.isPerfectSquare(arr.length))
			return 0;

		int sum = 0;
		int root = (int) Math.sqrt(arr.length);
		for (int i = 1; i <= root; i++) {
			sum += arr[(i * root) - (i)];
		}
		return sum;
	}

	/**
	 * prints the elements of the single dimensional array passed as argument
	 * 
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	/**
	 * This method reverses the array
	 * 
	 * @param arr
	 */
	public static void reverseArray(int[] arr) {
		int mid = arr.length / 2;
		for (int i = 0; i < mid; i++) {
			swap(arr, arr.length - (i + 1), i);
		}
	}

	/**
	 * This method swaps two elements in an array using input parameters
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[j] ^ arr[i];

	}

	/**
	 * This method sorts the input integer array using bubble sort technique
	 * 
	 * @param arr
	 */
	public static void sort(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
			}
		}
	}

	/**
	 * returns the maximum value in an integer array
	 * 
	 * @param arr :
	 *            input array
	 * @return max : maximum value
	 */
	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	/**
	 * returns the minimum value in an integer array
	 * 
	 * @param arr :
	 *            input array
	 * @return max : maximum value
	 */
	public static int min(int[] arr) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	/**
	 * removes the element and all its occurrences from the array passed as
	 * argument and returns the sliced array.
	 * 
	 * @param arr
	 * @param element
	 * @return
	 */
	public static void removeElement(int[] arr, int element) {
		int length = arr.length;

		for (int i = 0; i < length; i++)
			if (element == arr[i]) {
				for (int j = i; j < length - 1; j++)
					arr[j] = arr[j + 1];
				length--;
			}
		if (length < arr.length) {
			int arr1[] = new int[length];
			System.arraycopy(arr, 0, arr1, 0, length);
			printArray(arr1);
			return;
		}
		return;
	}
	
	public static void printObjectArray(Object[] arr) {
		for (Object o : arr) {
			System.out.print(o + " ");
		}
		System.out.println();
	}
}
