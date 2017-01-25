package com.util.objectOperations;

import java.util.UUID;

@SuppressWarnings({
        "unchecked", "rawtypes"
})
public class SortUtil {

	public void bubbleSort(Comparable [] localArray) {
		int n = localArray.length;
		int k;
		for (int m = 0; m < n; m++) {
			for (int i = 0; i < n - 1; i++) {
				k = i + 1;
				if (localArray[i].compareTo(localArray[k]) > 0)
					swapNumbers(i, k, localArray);
			}
		}
	}

	public void selectionSort(Comparable [] localArray) {
		int n = localArray.length;
		for (int i = 0; i < n - 1; i++) {
			int index = i;
			for (int j = i + 1; j < n; j++)
				if (localArray[j].compareTo(localArray[index]) < 0)
					index = j;
			swapNumbers(i, index, localArray);
		}
	}

	public void insertionSort(Comparable [] localArray) {
		int n = localArray.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (localArray[j].compareTo(localArray[j - 1]) < 0) {
					swapNumbers(j, j - 1, localArray);
				}
			}
		}
	}

	public void quickSort(int lowerIndex, int higherIndex, Comparable [] localArray) {
		int i = lowerIndex;
		int j = higherIndex;
		Comparable pivot = localArray[lowerIndex + (higherIndex - lowerIndex) / 2];
		while (i <= j) {
			while (localArray[i].compareTo(pivot) < 0) {
				i++;
			}
			while (localArray[j].compareTo(pivot) > 0) {
				j--;
			}
			if (i <= j) {
				swapNumbers(i, j, localArray);
				i++;
				j--;
			}
		}
		if (lowerIndex < j) {
			quickSort(lowerIndex, j, localArray);
		}
		if (i < higherIndex) {
			quickSort(i, higherIndex, localArray);
		}
	}

	public void mergeSort(Comparable [] a) {
		Comparable [] tmp = new Comparable[a.length];
		mergeSort(a, tmp, 0, a.length - 1);
	}

	private void mergeSort(Comparable [] a, Comparable [] tmp, int left, int right) {
		if (left < right) {
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}

	private void merge(Comparable [] a, Comparable [] tmp, int left, int right, int rightEnd) {
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd)
			if (a[left].compareTo(a[right]) <= 0)
				tmp[k++] = a[left++];
			else
				tmp[k++] = a[right++];

		while (left <= leftEnd) // Copy rest of first half
			tmp[k++] = a[left++];

		while (right <= rightEnd) // Copy rest of right half
			tmp[k++] = a[right++];

		// Copy tmp back
		for (int i = 0; i < num; i++, rightEnd--)
			a[rightEnd] = tmp[rightEnd];
	}

	public void swapNumbers(int i, int j, Comparable [] localArray) {
		Comparable temp = localArray[i];
		localArray[i] = localArray[j];
		localArray[j] = temp;
	}

	public static String [] generateRandomStringArray(int size) {
		String [] localArray = new String[size];

		for (int i = 0; i < size; i++) {
			localArray[i] = UUID.randomUUID().toString();
		}
		return localArray;
	}

	public static Double [] generateRandomDoubleArray(int size) {
		Double [] localArray = new Double[size];

		for (int i = 0; i < size; i++) {
			localArray[i] = (double) (Math.random() * 100000);
		}
		return localArray;
	}

	public static Integer [] generateRandomIntegerArray(int size) {
		Integer [] localArray = new Integer[size];

		for (int i = 0; i < size; i++) {
			localArray[i] = (int) (Math.random() * 100000);
		}
		return localArray;
	}

}
