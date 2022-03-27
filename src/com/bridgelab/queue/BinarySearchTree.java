package com.bridgelab.queue;

import java.util.Scanner;

public class BinarySearchTree {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter total number of nodes");
		int noOfNodes = scanner.nextInt();
		long noOfTree = possibleCombinations(noOfNodes);
		System.out.println(noOfTree);

	}
}
