package com.bridgelab.queue;

import java.util.Scanner;

public class PalindromeChecker {
	Dqueue<Character> dQ;
	public static void main(String[] args) {
		PalindromeChecker pCheck=new PalindromeChecker();
		pCheck.dQ=new Dqueue<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		String word=sc.next();
		char letters[]=word.toCharArray();
		for(int i=0;i<letters.length;i++){
			pCheck.dQ.addRear(letters[i]);
		}
		System.out.println(pCheck.checkPalindrome());

	}

	private boolean checkPalindrome() {
		boolean isPalindrome=false;
		while(!dQ.isEmpty()){
			if(dQ.size()!=1){
				if(dQ.removeFront().equals(dQ.removeRear())){
					isPalindrome=true;
				}else{
					isPalindrome=false;
					break;
				}
			}else{
				dQ.removeRear();
				isPalindrome=true;
			}
		}
		return isPalindrome;
		
	}



}
