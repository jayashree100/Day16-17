package com.bridgelab.stack;

import java.util.Arrays;
import java.util.Stack;

public class PrimeAnagram {
	public static boolean prime(int n) {
		boolean flag = true;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}

	public static boolean check(Object m, Object n) {
		String a = String.valueOf(m);
		String b = String.valueOf(n);
		char[] c1 = a.toCharArray();
		char[] c2 = b.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (Arrays.equals(c1, c2)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 1;
		int end = 100;
		Stack<Integer> a = new Stack<Integer>();
		Stack<Object> b = new Stack<Object>();
		for (int n = start; n <= end; n++) {
			if (prime(n)) {
				a.push(n);
			}
		}
		System.out.println(a);
		start = start + 100;
		end = end + 100;
		for (int j = 1; j < a.size(); j++) {
			for (int k = j + 1; k < a.size(); k++) {
				Object m = a.elementAt(j);
				Object n = a.elementAt(k);
				if (check(m, n)) {
					b.push(m);
					b.push(n);
				}
			}
		}
		System.out.println(b);
	}

}