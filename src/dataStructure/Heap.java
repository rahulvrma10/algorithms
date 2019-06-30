package dataStructure;

import java.util.Arrays;

//binary tree + root is smallest
public class Heap {

	int capacity = 10 ;
	int size = 0;
	int[] heap = new int[capacity] ; 


	// main method to sort the min - heap
	private void swap(int indexOne , int indexTwo) {
		int temp =  heap[indexOne] ;
		heap[indexOne] = heap[indexTwo] ; 
		heap[indexTwo] = temp;

	}

	//ensure no index out of bound when adding an element 
	private void increaseSizeIfNoCapacity(){
		if(size == capacity) {
			heap = Arrays.copyOf(heap, capacity * 2);
			capacity = capacity * 2 ;
		}
	}

	//see minimum element
	private int peek() {
		return heap[0];
	}

	//add a new element
	private void add(int element) {
		increaseSizeIfNoCapacity(); 
		heap[size] = element ;
		heapifyUp(size);
		size++ ;
	}

	// remove smallest element
	private int poll() {
		if(size == 0 ) {
			throw new IllegalStateException();
		}
		int smallestEle =  heap[0];
		heap[0] = heap[size - 1] ; 
		size -- ;
		heapifyDown(0);
		return smallestEle ; 
	}

	//sort heap when a new index is added 
	private void heapifyUp(int index ) {
		if(hasParent(index) &&  heap[index] < parent(index)) {
			swap(index , getParentIndex(index)) ;
			heapifyUp(getParentIndex(index)) ; 
		}
	}

	//sort heap when smallest index is removed from top
	private void heapifyDown(int index) {
//		/so after some time as  i could not make logic
	}


	//helper methods
	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2 ;
	}
	private int getRightChildIndex(int parentIndex) {
		return (2 * parentIndex) + 2 ; 
	}
	private int getLeftChildIndex(int parentIndex) {
		return (2 * parentIndex) + 1 ; 
	}

	private int rightChild(int parentIndex) {
		return heap[getRightChildIndex(parentIndex)] ; 
	}
	private int leftChild(int parentIndex) {
		return heap[getRightChildIndex(parentIndex)] ; 
	}
	private int parent(int childIndex) {
		return heap[getParentIndex(childIndex)] ; 
	}

	
	private boolean hasParent(int childIndex) {
		return getParentIndex(childIndex) < 0 ? false : true ; 
 	}
	private boolean hasLeftChild(int parentIndex) {
		return getLeftChildIndex(parentIndex) < size;
	}
	public static void main(String[] args) {


		Heap heap = new Heap() ; 
		heap.add(4);
		heap.add(3);
		heap.add(2);
		heap.add(1);
		System.out.println(heap.peek());

		
	}

}
