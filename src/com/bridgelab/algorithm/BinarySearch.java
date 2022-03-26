package com.bridgelab.algorithm;

import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
		String sentence = sc.next();
		String[] arrayOfString = sentence.toLowerCase().split(",");
		BinarySearch binary = new BinarySearch();

		for (int i = 0; i < arrayOfString.length - 1; i++) {
			for (int j = i + 1; j < arrayOfString.length; j++) {
				if (arrayOfString[i].compareTo(arrayOfString[j]) > 0) {
					String temp = arrayOfString[i];
					arrayOfString[i] = arrayOfString[j];
					arrayOfString[j] = temp;
				}
			}
		}
		System.out.println("Enter word to search");
		String word = sc.next();

		binary.binarySearch(arrayOfString, 0, arrayOfString.length, word);
	}

	public void binarySearch(String[] array, int low, int high, String data) {

		int mid = (low + high) / 2;

		if (data.equals(array[mid])) {
			System.out.println(data + " word is found ");
			return;
		}

		if (mid == low || mid == high) {
			System.out.println(data + " word cant found  ");
			return;
		}

		else if (data.compareTo(array[mid]) > 0)
			binarySearch(array, mid, high, data);
		else
			binarySearch(array, low, mid, data);
	}
}
