package com.bridgelab.algorithm;

public class BubbleSort {
	public static void main(String[] args) {

		BubbleSort sort = new BubbleSort();
		String sentence = "hi,guys,welcome,to,Bridgelabz";
		String array[] = sentence.toLowerCase().split(",");
		sort.bubbleSort(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public void bubbleSort(String[] array) {
		String temp;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j].compareTo(array[j + 1]) > 0) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}

	}
}