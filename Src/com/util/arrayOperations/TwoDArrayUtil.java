package com.util.arrayOperations;

import java.util.Scanner;

import com.util.validationOperations.InputValidator;

public abstract class TwoDArrayUtil {
    private TwoDArrayUtil() {
    }

    /**
     * reads values from user and returns an integer array
     * 
     * @return
     */
    public static int[][] read() {
	int rows = 0, cols = 0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of rows for your array : ");
	String srows = sc.next();
	if (InputValidator.isNumber(srows))
	    rows = Integer.parseInt(srows);
	else {
	    System.out.println("Required integer format not received.");
	    read();
	}
	System.out.println("Enter the number of columns for your array : ");
	String scols = sc.next();
	if (InputValidator.isNumber(scols))
	    cols = Integer.parseInt(scols);
	else {
	    System.out.println("Required integer format not received.");
	    read();
	}
	int[][] out = new int[rows][cols];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		System.out.println("Enter element at Row:" + (i + 1) + " Column: " + (j + 1));
		String str = sc.next();
		out[i][j] = InputValidator.isNumber(str) ? Integer.parseInt(str) : 0;
	    }
	}
	return out;

    }

    /**
     * reads values from user and returns a double array
     * 
     * @return
     */
    public static double[][] readD() {
	int rows = 0, cols = 0;
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the number of rows for your array : ");
	String srows = sc.next();
	if (InputValidator.isNumber(srows))
	    rows = Integer.parseInt(srows);
	else {
	    System.out.println("Required integer format not received.");
	    read();
	}
	System.out.println("Enter the number of columns for your array : ");
	String scols = sc.next();
	if (InputValidator.isNumber(scols))
	    cols = Integer.parseInt(scols);
	else {
	    System.out.println("Required integer format not received.");
	    read();
	}
	double[][] out = new double[rows][cols];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		System.out.println("Enter element at Row:" + (i + 1) + " Column: " + (j + 1));
		String str = sc.next();
		out[i][j] = InputValidator.isDoubleOrNumber(str) ? Double.parseDouble(str) : 0;
	    }
	}
	return out;

    }

    /**
     * prints a integer array
     * 
     * @param arr
     */
    public static void printArray(int[][] arr) {
	if (arr == null) {
	    System.out.println("The arrays entered were not equi-dimensional");
	    return;
	}
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
		System.out.print(arr[i][j] + "\t");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    /**
     * prints a double array
     * 
     * @param arr
     */
    public static void printArray(double[][] arr) {
	if (arr == null) {
	    System.out.println("The arrays entered were not equi-dimensional");
	    return;
	}
	for (int i = 0; i < arr.length; i++) {
	    for (int j = 0; j < arr[i].length; j++) {
		System.out.print(arr[i][j] + "\t");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    /**
     * returns the row count of the integer array passed
     * 
     * @param m
     * @return
     */
    public static int getRows(int[][] m) {
	return m.length;
    }

    /**
     * returns the column count of the double array passed
     * 
     * @param m
     * @return
     */
    public static int getRows(double[][] m) {
	return m.length;
    }

    /**
     * returns the column count of the integer array passed
     * 
     * @param m
     * @return
     */
    public static int getCols(int[][] m) {
	int l = m[0].length;
	for (int i = 0; i < m.length; i++) {
	    if (l != m[i].length) {
		System.out.println("Jagged Array detected,Array not " + "fit enough for matrix operation");
		return -1;
	    }
	}
	return m[0].length;
    }

    /**
     * returns the column count of the double array passed
     * 
     * @param m
     * @return
     */
    public static int getCols(double[][] m) {
	int l = m[0].length;
	for (int i = 0; i < m.length; i++) {
	    if (l != m[i].length) {
		System.out.println("Jagged Array detected,Array not " + "fit enough for matrix operation");
		return -1;
	    }
	}
	return m[0].length;
    }

    /**
     * returns if two integer arrays passed are equidimensional
     * 
     * @param m
     * @return
     */
    public static boolean isEquiDimensional(int[][] x, int[][] y) {
	return ((getRows(x) == getRows(y)) && (getCols(x) == getCols(y)));
    }

    /**
     * returns if two double arrays passed are equidimensional
     * 
     * @param m
     * @return
     */
    public static boolean isEquiDimensional(double[][] x, double[][] y) {
	return ((getRows(x) == getRows(y)) && (getCols(x) == getCols(y)));
    }

    /**
     * returns if two integer arrays passed are compatible for array
     * multiplication
     * 
     * @param m
     * @return
     */
    public static boolean isCompatible(int[][] x, int[][] y) {
	return ((getCols(x) == getRows(y)));
    }

    /**
     * returns if two double arrays passed are compatible for array
     * multiplication
     * 
     * @param m
     * @return
     */
    public static boolean isCompatible(double[][] x, double[][] y) {
	return ((getCols(x) == getRows(y)));
    }

    /**
     * adds two integer arrays and returns a sum array
     * 
     * @param x
     * @param y
     * @return
     */
    public static int[][] add(int[][] x, int[][] y) {
	int[][] sum;
	if (isEquiDimensional(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(x);
	    sum = new int[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    sum[i][j] = x[i][j] + y[i][j];
		}
	    }
	    return sum;
	} else
	    return null;
    }

    /**
     * adds two double arrays and returns a sum array
     * 
     * @param x
     * @param y
     * @return
     */
    public static double[][] add(double[][] x, double[][] y) {
	double[][] sum;
	if (isEquiDimensional(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(x);
	    sum = new double[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    sum[i][j] = x[i][j] + y[i][j];
		}
	    }
	    return sum;
	} else
	    return null;
    }

    /**
     * subtracts y from x and returns a difference array
     * 
     * @param x
     * @param y
     * @return
     */
    public static int[][] subtract(int[][] x, int[][] y) {
	int[][] difference;
	if (isEquiDimensional(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(x);
	    difference = new int[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    difference[i][j] = x[i][j] - y[i][j];
		}
	    }
	    return difference;
	} else
	    return null;
    }

    /**
     * subtracts y from x and returns a difference array
     * 
     * @param x
     * @param y
     * @return
     */
    public static double[][] subtract(double[][] x, double[][] y) {
	double[][] difference;
	if (isEquiDimensional(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(x);
	    difference = new double[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    difference[i][j] = x[i][j] - y[i][j];
		}
	    }
	    return difference;
	} else
	    return null;
    }

    /**
     * multiplies two integer arrays and returns a product array
     * 
     * @param x
     * @param y
     * @return
     */
    public static int[][] multiply(int[][] x, int[][] y) {
	int[][] product;
	if (isCompatible(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(y);
	    product = new int[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    for (int k = 0; k < TwoDArrayUtil.getRows(y); k++)
			product[i][j] += x[i][k] * y[k][j];
		}
	    }
	    return product;
	}
	System.out.println("The arrays entered are not compatible for multiplication");
	return null;
    }

    /**
     * multiplies two double arrays and returns a product array
     * 
     * @param x
     * @param y
     * @return
     */
    public static double[][] multiply(double[][] x, double[][] y) {
	double[][] product;
	if (isCompatible(x, y)) {
	    int rows = TwoDArrayUtil.getRows(x);
	    int cols = TwoDArrayUtil.getCols(y);
	    product = new double[rows][cols];
	    for (int i = 0; i < rows; i++) {
		for (int j = 0; j < cols; j++) {
		    for (int k = 0; k < TwoDArrayUtil.getRows(y); k++)
			product[i][j] = product[i][j] + x[i][k] * y[k][j];
		}
	    }
	    return product;
	}
	System.out.println("The arrays entered are not compatible for multiplication");
	return null;
    }

    /**
     * can also print jagged 2-dimensional arrays
     * 
     * @param arr
     */
    public static void printMatrix(int[][] arr) {
	int x = arr[0].length;
	int y = arr.length;

	for (int i = 0; i < y; i++) {
	    for (int j = 0; j < x; j++) {

		System.out.print(arr[i][j] + "\t");
	    }
	    System.out.println();
	}
    }

}
