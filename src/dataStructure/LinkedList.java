package dataStructure;

public class LinkedList {

	Node head ; 	
	class Node{

		Node next ;
		int data; 

		Node(int data){
			this.data = data ;
		}
	}

	private void append(int data) {
		if(this.head == null) {
			head = new Node(data) ;
			return ; 
		}
		Node current = this.head ; 
		while(current.next !=null) {
			current = current.next ; 
		}
		current.next = new Node(data);
	}
	
	private void prepend(int data) {
//		if(this.head == null) {  NOT REQUIRED
//			head = new Node(data) ;
//			return ; 
//		}
		
		
		Node head = new Node(data) ; 
		head.next = this.head ; 
		
		this.head = head ;
		System.out.println("appended "+ data);
	}

	private boolean delete(int data) {
		
		Node current = this.head ; 
		if(current.data == data) {
			this.head = current.next  ; //head is matching element
			return true ; 
		}
		
		while(current.next !=null ) {
			if(current.next.data == data) {
				if(current.next.next ==null) 
					current.next = current.next.next ; //matching element is  either last or not last 
				return true ; 
			}
			current = current.next ; 
		}
	
		return false ; 
	}
	
	private boolean hasCycle(){

		Node slow = this.head ; 
		Node fast = this.head.next ; 
		
		while(fast!=null && fast.next != null  ) { 
			
			if(slow == fast) {
				return true; 
			}
			fast = fast.next.next ; 
			slow = slow.next ; 
		}
		
		return false ;
		
	}
	
	private Node get(int index) {
		Node current = this.head ;
		if(index == 0) {
			return current ; 
		}
		for(int i = 1 ;  i <= index ; i ++) {
				current = current.next ;
				if(current == null) {
					return null ; 
				}
		}
		return current ; 
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList() ; 
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		//list.get(3).next = list.get(1) ; 
		
		//System.out.println("done"+ list.delete(5));
		System.out.println(list.hasCycle());
		System.out.println("element :" + list.get(4)) ;
					
	}

}
