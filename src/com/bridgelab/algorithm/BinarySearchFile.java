package com.bridgelab.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class BinarySearchFile {
	public static int binarySearch(List<String> alist, String x) {
		int l = 0;
		int r = alist.size();
		while (l <= r) {
			int mid = l + (r - 1) / 2;
			int res = x.compareTo(alist.get(mid));
			if (res == 0)
				return mid;
			if (res > 0)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		List<String> l = new ArrayList<String>();
		File file = new File("D:Binary_Search.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			l.add(st);
		}
		System.out.println("Enter the name for Search");
		String x = sc.nextLine();
		Collections.sort(l);
		System.out.println(l);
		int val = binarySearch(l, x);
		if (val == -1)
			System.out.println("Name did not found");
		else
			System.out.println("found at position  " + val);
		sc.close();
		br.close();
	}

}