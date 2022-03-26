package com.bridgelab.algorithm;

import java.util.Scanner;

public class FindYourNumber {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Please select any number in mind");
		System.out.print("Enter the upper range : ");
		int range = scan.nextInt();

		FindYourNumber number1 = new FindYourNumber();
		number1.findNumber(0, range);

	}

	public void findNumber(int low, int high) {

		Scanner scan = new Scanner(System.in);

		int mid = (low + high) / 2;

		System.out.println("Enter your choice");
		System.out.println("1)Greater than " + mid);
		System.out.println("2)Equal to " + mid);
		System.out.println("3)Less than " + mid);
		int choice = scan.nextInt();

		switch (choice) {
		case 1:
			if (high - mid == 1) {
				findNumber(high, high);
				break;
			}
			findNumber(mid, high);
			break;
		case 2:
			System.out.println("Got the final number");
			return;
		case 3:
			findNumber(low, mid);
			break;
		default:
			System.out.println(" Please enter a valid input: ");
		}
	}
}