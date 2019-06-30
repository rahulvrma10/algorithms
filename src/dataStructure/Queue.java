package dataStructure;

import dataStructure.LinkedList.Node;

public class Queue {

	
	Node head ; //remove from head 
	Node tail ; //add onto tail
	
	class Node{

		Node next ;
		int data; 

		Node(int data){
			this.data = data ;
		}
	}
	
	private void add(int data) {
		
		Node node  = new Node(data);
		
		if(tail == null) {
			tail = node ;
			head = node ; 
			return ;
		}
		tail.next = node ; 
		tail = node ;
		
		
	 
	}
	
	private int remove() {

		if(head == null) {
			return -1 ;
		}
		
		int data = head.data ; 
		head = head.next ; 
		
		if(head == null) {
			tail = null ;  //mind this
		}
		
		return data ; 
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
