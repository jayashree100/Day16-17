package com.bridgelab.stack;

import java.util.Scanner;

public class AirthmaticExpression {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> stack=new Stack<Character>();
		System.out.println("Enter Arithmatic expression");
		Scanner scanner=new Scanner(System.in);
		String expresion=scanner.next();
		char expn[]=expresion.toCharArray();
		for(int i=0;i<expn.length;i++){
			if(expn[i]=='('){
				stack.push(expn[i]);
			}else if(expn[i]==')'){
				if(stack.isEmpty()){
					stack.push(expn[i]);
					break;
				}
				stack.pop();
			}
		}
		System.out.println(stack.isEmpty());
}
}