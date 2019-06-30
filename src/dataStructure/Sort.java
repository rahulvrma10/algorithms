package dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

	
	private List<Integer> swap(List<Integer> list , int index1 , int index2) {
		int temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
		return list ;
	}
	private List<Integer> bubbleSort(List<Integer> list){
		
		boolean isSorted = false ;
		int lastUnsortedSize = list.size() - 1;
		while(!isSorted) {
//			If in the for loop, element at lower index is always < element at highr index, 
//			isSOrted remains true and breaks the while loop
			isSorted = true ;
			for(int i = 0 ; i < lastUnsortedSize  ; i ++) {
				if(list.get(i) > list.get(i+1)) {
					//swap
					list = this.swap(list, i, i+1);
					isSorted = false ;
				}
			}
//			after the first iteration of for-loop we get the largest element at the last index, 
//			hence excluding it by decreasing the size of list
			lastUnsortedSize  -- ;
			
		}
		return list ; 
	}
	
	
	private void quickSort(List<Integer> list){
		
		
		quickSort(list, 0 , list.size() - 1 );
		
		
	}
	
	
	private void quickSort(List<Integer> list, int start, int end) {
		
		if(start  < end) {  // exclude fn calls where start = end (only one element cant be sorted) , start > end
			int pivot = list.get((start + end) / 2) ;
			int pIndex = partition(list, pivot, start, end) ; 
			quickSort(list,start, pIndex - 1);
			quickSort(list,pIndex, end);
		}
	}


	private int partition(List<Integer> list, int pivot, int start, int end) {
		
		while(start <= end) {
			while(list.get(start)  < pivot) { // get the index which is greater than pivot
				start ++ ;	
			}
			while(list.get(end) > 	 pivot) { // get index which is smaller than pivot
				end -- ;
			}
			
			if(start <= end) { 
				swap(list,start,end);
				start ++ ; //move pointers as elemnts swapped
				end -- ;
			}
		}

		return start ; 
		
		
	}


	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,1,5));
		System.out.println("Unsorted list : "+ list);
		
		Sort sort = new Sort() ;
		//System.out.println("Bubble sort : "+sort.bubbleSort( list));
		sort.quickSort(list);
		System.out.println("Quick sort : "+ list);
			
	}

}
