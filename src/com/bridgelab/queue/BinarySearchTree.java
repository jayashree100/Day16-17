package com.bridgelab.queue;

import java.util.Scanner;

public class BinarySearchTree {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of nodes");
		int noOfNodes = scanner.nextInt();
		long noOfTree = Utility.possibleCombinations(noOfNodes);
		System.out.println(noOfTree);

	}
}
