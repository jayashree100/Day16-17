package com.bridgelab.stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MyorderList {
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

	public static void main(String args[]) {
		String filePath = "D:Number.txt";
		String num[] = readFile(filePath);
		OrderedList<Integer> list = new OrderedList<Integer>();
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);
			list.add(Integer.parseInt(num[i]));
		}
		System.out.println("Enter number to search");
		int numSearch = sc.nextInt();
		if (list.search(numSearch)) {
			System.out.println("Number is present");
			list.remove(numSearch);
		} else {
			System.out.println("Number added");
			list.add(numSearch);
		}

		num = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			num[i] = String.valueOf(list.get(i));
			System.out.println(num[i]);
		}
		writeFile(num, filePath);
	}

}
