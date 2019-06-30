package dataStructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Test{

	static HashSet<MyClass> set = new HashSet<MyClass>();
	
	public static void main(String[] args) {

	}
	
	
// find the first non repeating char in stirng : used linkedhashmap to preserve the insertion order	
	
//	String str = "aabbccdeeddtpqaacc" ;
//	LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
//	for(int i = 0 ;i< str.length() ;i ++ ) {
//		Integer count = map.get(String.valueOf(str.charAt(i))) ;
//		map.put(String.valueOf(str.charAt(i)), count == null ? 1 : count + 1);
//	}
//	System.out.println(map);
//	for(String s :  map.keySet()) {
//		if(map.get(s) == 1) {
//			System.out.println(map.get(s));
//			break;
//		}
//	}
	
// fibonacchi
//	
//	int[] memo = new int[5] ;
//	System.out.println(computeFib(4,memo));;
//	public static int computeFib(int n, int[] memo){
//		if(n <= 0) {
//			return 0 ;
//		}else if(n == 1) {
//			return 1 ;
//		}else {
//			memo[n] = computeFib(n-1,memo) + computeFib(n-2,memo) ;
//			
//		}
//		
//		return memo[n] ;
//		
//	}
	
	
// lonley integer ::
	
//	int []array = {11,22,22,3,4,5,2,2,3,4,} ;
//	HashMap<Integer,Integer>  intMap = new HashMap<Integer,Integer>();
//
//	for(int digit: array) {
//		 if(intMap.get(digit)!= null) {
//			 System.out.println("value S "+intMap.get(digit));
//			 int count = intMap.get(digit)+1 ;
//			 intMap.put(digit,count ) ;
//		 }else {
//			 intMap.put(digit, 1);		
//		 }
//	}
//
//	
//	System.out.println(intMap);
	
	
//	count of letters to remove for anagram ::
	
//	String first = "aaa";
//	String second = "a";
//	String secondTemp = second ;
//	
//	
//	int count = 0 ;
//	char[] firstLetters = first.toCharArray() ; 
//	for(char letter : firstLetters) {
//		secondTemp = second.replaceFirst(String.valueOf(letter), "");
//		if(secondTemp.equals(second)) {
//			count ++ ;
//		}else {
//			second = secondTemp ;
//		}			
//	}
//	System.out.println(secondTemp);
//	count += secondTemp.length() ;
//	System.out.println(count);

}







