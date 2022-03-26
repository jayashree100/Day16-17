package com.bridgelab.queue;

public class Dqueue <T>{
	UnOrderedList<T> list= new UnOrderedList<T>();
	public void addFront(T item){
		list.insert(0,item);
	}
	public void addRear(T item){
		list.append(item);
	}
	public T removeFront(){
		return list.pop(0);
	}
	public T removeRear(){
		return list.pop();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public int size(){
		return list.size();
	}
	public void printList() {
		// TODO Auto-generated method stub
		list.printList();
	}

}
