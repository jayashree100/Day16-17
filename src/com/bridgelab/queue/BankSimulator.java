package com.bridgelab.queue;

import java.util.Scanner;

public class BankSimulator {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args) {
		Queue<String> queue =new Queue<>();
		int cash=0;
		System.out.println("Enter number of people in line");
		int numberOfPeople=scanner.nextInt();
		Utility.addPeople(queue,numberOfPeople);
		while(!queue.isEmpty()){
			while(!queue.isEmpty()){
				String task=queue.dequeue();
				if(task.equals("Withdraw")){
					cash=Utility.withdraw(cash);
				}else if(task.equals("Deposite")){
					cash=Utility.deposite(cash);
				}
			}
		System.out.println("how many people added in line?");	
		numberOfPeople=scanner.nextInt();
		Utility.addPeople(queue,numberOfPeople);
		}
		//System.out.println(bank.cash>=0);
	}

}
