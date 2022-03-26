package com.bridgelab.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HashSearch {
	public static void main(String[] args) {
		HashSearch hash = new HashSearch();
		Scanner sc = new Scanner(System.in);
		String filePath = "D:Number.txt";
		String number[] = Utility.readFile(filePath);
		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
		for (int i = 0; i < 11; i++) {
			map.put(i, new LinkedList<Integer>());
		}
		for (int i = 0; i < number.length; i++) {
			int numberToAdd = Integer.parseInt(number[i]);
			map.get(numberToAdd % 11).add(numberToAdd);
		}
		System.out.println("Enter number to search");
		int search = sc.nextInt();
		if (hash.findNumber(map, search)) {
			System.out.println("Number is present");
			int index = map.get(search % 11).index(search);
			map.get(search % 11).pop(index);
		} else {
			map.get(search % 11).add(search);
			System.out.println("Number Added to the file");
		}
		hash.writeInFile(map, filePath);
	}

	public boolean findNumber(HashMap<Integer, LinkedList<Integer>> map, int number) {
		return map.get(number % 11).search(number);
	}

	public static void writeInFile(HashMap<Integer, LinkedList<Integer>> map, String file) {
		String numbers[] = {};
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < map.size(); i++) {
			int j = 0;
			while (j < map.get(i).size()) {
				list.add(map.get(i).get(j) + "");
				j++;
			}
		}
		numbers = list.toArray(new String[list.size()]);
		Utility.writeFile(numbers, file);
	}

}