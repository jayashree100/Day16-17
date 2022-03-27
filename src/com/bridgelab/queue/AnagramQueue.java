package com.bridgelab.queue;

import java.util.Arrays;

public class AnagramQueue {

	public static boolean isPrime(int number) {

		// condition to check if no less than two
		if (number < 2) {
			return false;
		}

		// for loop to for checking prime no
		for (int factor = 2; factor * factor <= number; factor++) {
			// if factor divides evenly into n, n is not prime, so break out of
			// loop
			if (number % factor == 0) {
				return false;

			}
		} // End of for loop
		return true;
	}

	public static boolean isAnagram(String string1, String string2) {
		boolean isAnagram = true;
		char array1[] = string1.toLowerCase().toCharArray();
		char array2[] = string2.toLowerCase().toCharArray();
		Arrays.sort(array1);
		Arrays.sort(array2);
		if (array1.length != array2.length) {
			return false;
		} else {
			for (int i = 0; i < array1.length; i++) {
				if (array1[i] == array2[i]) {
					isAnagram = true;
				} else {
					isAnagram = false;
					break;
				}

			}
		}
		return isAnagram;
	}

	public static void findPrimeInRange(int[][] primeArray) {

		int number = 2;
		int k = 0;
		for (int i = 0; i < primeArray.length; i++) {
			for (int j = 0; j < primeArray[i].length && number < ((i + 1) * 100); j++) {
				if (isPrime(number)) {
					primeArray[i][k] = number;
					k++;
				}
				number++;
			}
			k = 0;
		}

	}

	public static String[][] primeAnagramInRange() {
		int primeArray[][] = new int[10][100];
		int k = 0;
		String primeAnagram[][] = new String[10][100];
		findPrimeInRange(primeArray);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 99 && primeArray[i][j] != 0; j++) {

				for (int x = j + 1; x < 100 && primeArray[i][x] != 0; x++) {

					if (isAnagram(String.valueOf(primeArray[i][j]), String.valueOf(primeArray[i][x]))) {
						// System.out.println(primeArray[i][j]+" "+primeArray[i][x]);
						primeAnagram[i][k] = String.valueOf(primeArray[i][j]);
						k++;
						primeAnagram[i][k] = String.valueOf(primeArray[i][x]);
						k++;
					}
				}

			}
			k = 0;
		}
		return primeAnagram;
	}

	public static void main(String[] args) {
		Queue<String> anagramQ = new Queue<String>();
		String primeArray[][] = primeAnagramInRange();
		for (int i = 0; i < primeArray.length; i++) {
			for (int j = 0; j < primeArray.length; j++) {
				if (primeArray[i][j] != null)
					anagramQ.enqueue(primeArray[i][j]);
			}
		}
		while (anagramQ.size() != 0) {
			System.out.println(anagramQ.dequeue());

		}
	}

}
