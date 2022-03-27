package com.bridgelab.stack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class AddWord {
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

	public static void main(String[] args) {
		String filePath = "D:Binary_Search.txt";
		String words[] = readFile(filePath);
		UnorderedList<String> linklist = new UnorderedList<>();
		for (int i = 0; i < words.length; i++) {
			linklist.add(words[i]);
		}
		linklist.printList();
		System.out.println("Enter word to search");
		Scanner scanner = new Scanner(System.in);
		String search = scanner.next();

		if (linklist.search(search)) {
			System.out.println("Word is already present in linked list");
		} else {
			appendFile(search, filePath);
			System.out.println("Word Added to list");
		}

	}

}
