package dataStructure;

public class Search {
	
	
	
	
	
	public boolean binaryRecursive(int arr[] , int iStart , int iEnd , int search ) {
		
		int mid = (iStart + iEnd) / 2 ;
		if(arr[mid] == search) {
			return true ;
		}
		if(arr[mid] == arr[iEnd] || arr[mid] == arr[iStart]) {
			return false ;
		}

		if(search < arr[mid]) {
			return binaryRecursive(arr, iStart, mid - 1, search);
		}else if(search > arr[mid]) {
			return binaryRecursive(arr, mid+1, iEnd, search);
		}
		return false ;
	}
	
	
	public boolean binaryIterative(int arr[] , int iStart , int iEnd , int search) {
		
		
		while(iStart <= iEnd) {
			int mid = (iStart + iEnd) / 2 ;
			if(arr[mid] == search ) {
				return true ;
			}
			if(search < arr[mid]) {
				iEnd = mid - 1 ;
				continue ;
			}else if(search > arr[mid]) {
				iStart = mid+1;
				continue ;
			}	
		}
		return false ;
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6} ;
		Search search = new Search() ;
		boolean isFound = search.binaryIterative(arr, 0, arr.length-1, 7);
		System.out.println(isFound);
	
	}

}
