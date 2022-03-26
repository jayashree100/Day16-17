package com.bridgelab.stack;

public class Prime2D {
	public static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		int k = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 100; j++) {
				if (isPrime(k)) {
					System.out.print(" " + k);
					k++;
				} else {
					k++;
				}
			}
			System.out.println(" ");
		}

	}

}