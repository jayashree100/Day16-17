package com.bridgelab.stack;

import java.util.Scanner;

public class AddWord {
	public static void main(String[] args) {
		String filePath="D:Binary_Search.txt";
		String words[]=Utility.readFile(filePath);
		UnorderedList<String> linklist=new UnorderedList<>();
		for(int i=0;i<words.length;i++){
			linklist.add(words[i]);
		}
		linklist.printList();
		System.out.println("Enter word to search");
		Scanner scanner=new Scanner(System.in);
		String search=scanner.next();
		
		
		if(linklist.search(search)){
			System.out.println("Word is already present in linked list");
		}else {
			Utility.appendFile(search,filePath);
			System.out.println("Word Added to list");
		}
		
		
	}


}
