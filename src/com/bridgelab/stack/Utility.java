package com.bridgelab.stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.bridgelab.queue.Queue;


public class Utility {
	static Scanner scanner = new Scanner(System.in);

	/**
	 * This method checks if given strings are anagram
	 * 
	 * @param string1
	 * @param string2
	 * @return It returns true if strings are anagram
	 */
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

	/**
	 * This method checks if given string is palindrome or not
	 * 
	 * @param string
	 * @return returns true if string is palindrome
	 */
	public static boolean isPalindrome(String string) {
		char array[] = string.toLowerCase().toCharArray();
		boolean isPalindrome = true;
		int j = array.length - 1;
		for (int i = 0; i < array.length; i++, j--) {
			if (array[i] == array[j]) {
				isPalindrome = true;
			} else {
				isPalindrome = false;
				return isPalindrome;
			}
		}
		return isPalindrome;

	}

	/**
	 * This method checks if given number is prime or not
	 * 
	 * @param number
	 * @return It returns true if number is prime
	 */
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

	/**
	 * This method read file into string array
	 * 
	 * @param filePath
	 * @return -Returns string array of words from file
	 */
	public static String[] readFile(String filePath) {
		String words[] = {};
		ArrayList<String> lines = new ArrayList<String>();
		String line, temp[] = {};
		BufferedReader bufferedReader;
		FileReader file;
		int index = 0;
		try {
			file = new FileReader(filePath);
			bufferedReader = new BufferedReader(file);
			while ((line = bufferedReader.readLine()) != null) {
				temp = line.split(",|\\s");
				for (int i = 0; i < temp.length; i++) {
					lines.add(temp[i]);

				}
			}
			words = lines.toArray(new String[lines.size()]);
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return words;
	}

	/**
	 * This method appends word on filePath
	 * 
	 * @param word
	 * @param filePath
	 * 
	 */
	public static void appendFile(String word, String filePath) {

		try {
			FileWriter writer = new FileWriter(filePath, true);
			PrintWriter out = new PrintWriter(writer);
			out.println(word);
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method write given string on given filePath
	 * 
	 * @param word     -Array of String to write
	 * @param filePath -File path with file name
	 */
	public static void writeFile(String word[], String filePath) {

		try {
			FileWriter writer = new FileWriter(filePath, false);
			PrintWriter out = new PrintWriter(writer);
			for (int i = 0; i < word.length; i++) {
				out.write(word[i] + " ");
			}
			out.close();
			writer.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method checks if given year is leap year or not
	 * 
	 * @param year
	 * @return returns true if year is leap else return false
	 */
	public static boolean isLeapYear(int year) {
		boolean isLeapYear;
		// divisible by 4
		isLeapYear = (year % 4 == 0);
		// divisible by 4 and not by 100
		isLeapYear = isLeapYear && (year % 100) != 0;
		// divisible by 4 and 400
		isLeapYear = isLeapYear || (year % 400) == 0;
		return isLeapYear;

	}

	public static void fillArray(String[][] days, int month, int year) {
		// TODO Auto-generated method stub
		int daysInMonth[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int dayCount = 1;
		String weekDays[] = { "S", "M", "T", "W", "Th", "F", "Sa" };
		int startDay = dayOfWeek(1, month, year);
		int j = 0;
		if (isLeapYear(year)) {
			daysInMonth[2] = 29;
		}
		for (int i = 0; i < 7; i++) {
			days[j][i] = weekDays[i];
		}

		for (int i = 1; i < 7; i++) {
			for (j = 0; j < 7; j++)
				if (startDay >= dayCount) {
					days[i][j] = " ";
					startDay--;

				} else if (dayCount <= daysInMonth[month]) {
					days[i][j] = String.valueOf(dayCount);
					dayCount++;
				} else {
					days[i][j] = " ";
				}
		}
	}

	public static void printCalender(String[][] days, int month, int year) {
		// TODO Auto-generated method stub
		String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		System.out.println(months[month - 1] + "\t" + year);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(days[i][j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * This method gives day of week for given day/month/year
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return returns 0 for sunday,1 for monday and so on
	 */
	public static int dayOfWeek(int day, int month, int year) {
		int m0, y0, d0, x;

		y0 = year - (14 - month) / month;
		x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
		m0 = month + 12 * ((14 - month) / 12) - 2;
		d0 = (day + x + (31 * m0) / 12) % 7;
		return d0;
	}

	/**
	 * This method stores prime numbers from 1 to 1000 in 2D array
	 * 
	 * @param primeArray
	 */
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

	/**
	 * This method stores prime numbers from 1 to 1000 which are anagram in 2D array
	 * 
	 * @return
	 */
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

	/**
	 * Added people with their operations
	 * 
	 * @param queue
	 * @param number
	 */
	public static void addPeople(Queue<String> queue, int number) {

		int choice;
		int i = 0;
		while (i < number) {
			System.out.println("Enter task of Person" + (i + 1) + " \n1.Withdraw \n2.Deposite");
			choice = scanner.nextInt();
			if (choice == 1) {
				queue.enqueue("Withdraw");
			} else if (choice == 2) {
				queue.enqueue("Deposite");
			}
			i++;
		}
	}

	/**
	 * This method take amount from user and withdraw it from given cash
	 * 
	 * @param cash
	 * @return Returns balance after withdraw
	 */
	public static int withdraw(int cash) {
		int amount = 0;
		System.out.println("Hello sir!\nEnter Amount to withdraw");
		amount = scanner.nextInt();
		if ((cash - amount) >= 0) {
			cash -= amount;
			System.out.println("Amount debited successfully");
		} else {
			System.out.println("Sorry not enough balance");
		}
		return cash;

	}

	/**
	 * This method take amount from user and add it to given cash
	 * 
	 * @param cash
	 * @return Returns balance after deposit
	 */
	public static int deposite(int cash) {
		int amount;
		System.out.println("Hello sir!\nEnter Amount to deposit");
		amount = scanner.nextInt();
		cash += amount;
		System.out.println("Amount credited successfully");
		return cash;
	}

	/**
	 * This method finds all possible combinations of binary search tree
	 * 
	 * @param totalNodes
	 * @return
	 */
	public static long possibleCombinations(int totalNodes) {
		long possibleTrees = 0;
		int count = 0;
		if (totalNodes <= 1)
			return 1;
		else {

			while (count < totalNodes) {
				count++;
				possibleTrees = possibleTrees
						+ possibleCombinations((int) count - 1) * possibleCombinations((int) totalNodes - count);
			}
			return possibleTrees;
		}
	}
}
