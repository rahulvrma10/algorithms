package Algorithms;

import java.util.Stack;

public class QueueFromStack {

	
	Stack<Integer> stackNewestTop = new Stack<Integer>() ; 
	Stack<Integer> stackOldestTop = new Stack<Integer>() ; 
	
	
	
	private int peek(){
		fillOldestTop() ; 
		return stackOldestTop.peek() ; 
	}
	
	private int dequeue() {
		fillOldestTop() ; 
		return stackOldestTop.pop() ; 
	}
	
	private void fillOldestTop() {
	
		if(stackOldestTop.isEmpty()) {
			while(!stackNewestTop.isEmpty()) {
				stackOldestTop.push(stackNewestTop.pop());
			}	
		}
		
	}

	private void enqueue(int data) {
		stackNewestTop.push(data) ; 
	}
	
	
	
	public static void main(String[] args) {

		QueueFromStack queue = new QueueFromStack() ; 
		queue.enqueue(1);
		queue.enqueue(2);
		System.out.println(queue.peek());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		//System.out.println(queue.peek());
	}

}
