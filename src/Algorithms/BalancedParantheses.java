package Algorithms;

import java.util.Stack;

public class BalancedParantheses {

	
	char[] close = {'}', ')' ,']'} ; 
	char[] open = {'{', '(' ,'['} ; 
	
	
	private boolean isOpenClose(Stack<Character> stack , char c ){
		for(int i=0 ; i < close.length ; i++) {
			if(stack.peek() == open[i] && c == close[i]) {
				return true ; 
			}
		}
		return false ;
	}
	
	private boolean checkBalance(String str){
		
		Stack<Character> stack = new Stack<>() ;
		
		for(int i = 0 ; i < str.length() ; i ++) {
			
			char c = str.charAt(i) ; 
			
			if(stack.isEmpty()) {
				stack.push(c);
			}else if(isOpenClose(stack,c) ) {
				stack.pop() ;
			}else {
				stack.push(c);
			}
			
		}

		return stack.isEmpty() ;
		
		
	}
	
	public static void main(String[] args) {
		
		String str = "[]()[{{}}";
		BalancedParantheses bp = new BalancedParantheses();

		System.out.println(bp.checkBalance(str ));
	}

}
