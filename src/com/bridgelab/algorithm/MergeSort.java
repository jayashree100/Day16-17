package com.bridgelab.algorithm;

public class MergeSort {
	public <T extends Comparable<T>> T[] mergeSort(T[] array, int start, int end) {
		if (end - start < 1) {
			return array;
		}

		int mid = (end + start) / 2;
		mergeSort(array, start, mid);
		mergeSort(array, mid + 1, end);

		return merge(array, start, mid, end);
	}

	public <T extends Comparable<T>> T[] merge(T[] array, int start, int mid, int end) {

		T[] Left = (T[]) new Integer[mid - start + 1];
		T[] Right = (T[]) new Integer[end - mid];

		for (int i = 0; i < mid - start + 1; i++)
			Left[i] = array[start + i];
		for (int i = 0; i < end - mid; i++)
			Right[i] = array[mid + i + 1];

		int k = start, i = 0, j = 0;

		while (i < Left.length && j < Right.length) {
			if (Left[i].compareTo(Right[j]) < 0)
				array[k++] = Left[i++];
			else
				array[k++] = Right[j++];
		}

		while (i < Left.length) {
			array[k++] = Left[i++];
		}
		while (j < Right.length) {
			array[k++] = Right[j++];
		}
		return array;
	}

	public void displaySort(Integer[] array) {
		for (Integer i : array) {
			System.out.print(" " + i);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		Integer array[] = { 40, 30, 10, 70, 50, 20, 60, 22, 44 };

		sort.mergeSort(array, 0, array.length - 1);
		sort.displaySort(array);
	}
}