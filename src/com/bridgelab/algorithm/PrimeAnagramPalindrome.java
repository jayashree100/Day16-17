package com.bridgelab.algorithm;

import java.util.Scanner;

public class PrimeAnagramPalindrome {

	public static void main(String[] args) {
		int lowerLimit, upperLimit;
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter lower limit: ");
		lowerLimit = sc.nextInt();
		System.out.println("Enter upper limit : ");
		upperLimit = sc.nextInt();

		PrimeAnagramPalindrome range = new PrimeAnagramPalindrome();
		System.out.println("Prime numbers between given range are that are anagram and palindrom are:");
		range.primeRange(lowerLimit, upperLimit);
	}

	public void primeRange(int lower, int upper) {

		for (int i = lower; i <= upper; i++) {
			if (i == 1 || i == 0) {
				continue;
			}
			int flag = 1;

			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					flag = 0;
					break;
				}
			}
			if (flag == 1) {
				palindrome(i);
			}
		}
	}

	public static void palindrome(int number) {

		int reverse = 0, remainder;
		int temp = number;
		while (number > 0) {
			remainder = number % 10;
			reverse = (reverse * 10) + remainder;
			number = number / 10;
		}
		if (temp == reverse) {
			System.out.println(temp);
		}
	}

}