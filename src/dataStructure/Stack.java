package dataStructure;

import dataStructure.Queue.Node;

public class Stack {
	

	Node top ; // only one pointer , head 
	class Node{
		Node next ;
		int data; 
		Node(int data){
			this.data = data ;
		}
	}
	
	
	private int peek() {
		return top == null ? -1 : top.data ; 
	}
	
	private void push(int data) {
		Node node =  new Node(data) ;
		node.next = top ; 
		top = node ; 
	}
	
	private int pop() {
		if(top == null) {
			return -1 ;
		}
		int data  = top.data ; 
		top = top.next ;
		return data; 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
