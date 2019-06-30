package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BST {

	BST.Node root ;
	
	public static class Node{
		int data ; 
		Node left , right ;
		Node(int value){
			this.data = value ;
		}
		
	}

	
	private void add(int value) {
		if(root == null) {
			root = new Node(value) ;
			System.out.println("added root node "+ root.data);
		}else {
			addNode(root,value);
		}
	}
	private void addNode(Node current, int value) {
		if(value <= current.data ) {
			if(current.left == null) {
				current.left = new Node(value) ;
				System.out.println("added value to left of "+current.data+ " : "+ current.left.data);
			}else {
				addNode(current.left,value);
			}
		}else if(value > current.data) {
			if(current.right == null) {
				current.right = new Node(value);
				System.out.println("added value to right of "+current.data+ " : "+ current.right.data);
			}else {
				addNode(current.right,value) ;
			}
		}
	}
	
	private boolean contains(int value) {
		if(containsNode(root,value)) {
				return true;
		}
		return false ; 
	}
	private boolean containsNode(Node current, int value) {
		if(current == null) {
			return false; 
		}
		System.out.println("evaluating currently node : "+current.data);
		if(value < current.data) {
			 return containsNode(current.left,value);
		}else if(value > current.data) {
			return containsNode(current.right,value);
		}else {
			return true;
		}
	}

	
	private void delete(int value) {
		if(this.root != null) {
			root = deleteRecursively(this.root,value);
		}
	}
	private Node deleteRecursively(Node current,int value) {
		if(current.data == value) {
			if(current.left == null && current.right == null) { //has no leaf nodes
				current = null ;
				return current ;
			}else if(current.left !=null && current.right != null ) { //has two leaf nodes
				
				//1. find smallest value in right nodes of current node
				int smallestValue = findSmallestValueInRight(current.right); 
				
				//2. copy value of smallest number to current node data
				current.data = smallestValue;
				
				//3. remove this smallest node | 
				//this smallest value has only 1 leaf node or NO leaf node , so calling deleteRecursively again!
				current.right = deleteRecursively(current.right, smallestValue);
				
			}else { //has one leaf node
				current =  current.left != null ? current.left : current.right ;
				return current ;
			}
		}else if(value < current.data && current.left!=null) { // will avoid goinf into this when there is no left node 
			current.left = deleteRecursively(current.left,value);
		}else if (value > current.data && current.right!=null) {
			current.right = deleteRecursively(current.right,value);
		}

		return current ; // returns current node up the stack 
	}
	private int findSmallestValueInRight(Node current) {
		int smallestValue = current.left == null ? current.data : findSmallestValueInRight(current.left);
		return smallestValue ;
	}
	
	
	private void inOrder(Node current) { // prints element in increasing order
		if(current.left !=null) {
			inOrder(current.left);
		}
		System.out.println(current.data);
		if(current.right !=null) {
			inOrder(current.right);
		}
	}
	
	private void preOrder(Node current) { // used to copy the BST to another BST
		
		System.out.println(current.data);
		if(current.left !=null) {
			preOrder(current.left);
		}
		if(current.right!=null) {
			preOrder(current.right);
		}
	}
	
	private void postOrder(Node current) {
		if(current.left !=null) {
			postOrder(current.left);
		}
		if(current.right!=null) {
			postOrder(current.right);
		}
		System.out.println(current.data);
		
	}
	
	//NOTE : checking if inOrder gives the elements in increasing order will also validate if binary tree is BST
	private boolean checkBST(Node root , int minBracket, int maxBracket) {
		
		if(root == null) { //flow recursively came till end node and found no element that is NOT in its bracket
			return true ;
		}
		if( root.data < minBracket || root.data > maxBracket) { // if element is not in bracket return false and break the recursion
			return false ;
		}
		// root.data - 1 as BST should no contain duplicate values
		return checkBST(root.left , minBracket, root.data - 1) & checkBST(root.right, root.data +1, maxBracket) ; 
	}
	
//	void BST makeBST(List<Integer> preOrder){
//		
//	}
	private void DFS() {
	
		Stack<Node> stack = new Stack<Node>() ;
		stack.push(this.root);
		while(!stack.isEmpty()) {
			
			Node current = stack.pop() ;
			System.out.println(current .data);

			if(current .left !=null) {
				stack.push(current.left);
			}
			if(current .right !=null) {
				stack.push(current.right);
			}
			
			
		}
	}

	private void BFS() {
		
	}
	
	public static void main(String[] args) {

//		List<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(10, 8,	7,  6,	9,	12,	11	)) ;
////		6
////		7
////		8
////		9
////		10
////		11
////		12		
		
		BST bst = new BST() ;
		bst.add(10);
		bst.add(8);
		bst.add(12);
		bst.add(9);
		bst.add(7);
		bst.add(6);
		bst.add(11);
		
		int delete = 5 ;
		System.out.println("BST contains : "+bst.contains(delete));;
		
		bst.delete(delete);
		System.out.println("BST contains : "+bst.contains(delete));;
		
		System.out.println("In order : ");
		bst.inOrder(bst.root);
		System.out.println("Pre order : ");
		bst.preOrder(bst.root);
		System.out.println("Post order : ");
		bst.postOrder(bst.root);
		
		System.out.println("DFS : ");
		bst.DFS();
		
		
		boolean isBst = bst.checkBST(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("Is bst : "+ isBst);
	}

}
