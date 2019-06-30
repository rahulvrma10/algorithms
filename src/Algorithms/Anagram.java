package Algorithms;

import dataStructure.Heap;

public class Anagram {

	String first = "afcrxzwscanmligyxyvym" ; 
	String second = "jxwtrhvujlmrpdoqbisbwhmgpmeoke" ; 
	
	int[] firstCount  = new int[26]; 
	int[] secondCount  = new int[26]; 
	
	public static void main(String[] args) {
		
		Anagram anagram = new Anagram() ;
		int counter = 0 ; 
		int offset  = (int)'a' ;
		
		for(int i = 0 ; i < anagram.first.length()  ; i++) {
			int firstIndex = (int)anagram.first.charAt(i) - offset ;
			System.out.println("incrementing firstCount at "+ firstIndex);
			anagram.firstCount[firstIndex]++ ; 
		}
		
		for(int i = 0 ; i < anagram.second.length() ; i++) {
			int secondIndex = (int)anagram.second.charAt(i) - offset ; 
			System.out.println("incrementing secondCount at "+ secondIndex);

			anagram.secondCount[secondIndex]++ ; 
			
		}
		
		for(int i=0 ; i < 26 ; i++) {
			counter+= Math.abs(anagram.firstCount[i] - anagram.secondCount[i]) ; 
		}
		
		System.out.println("To make anagram we will remove  "+counter+ " chars");
		
	}
	
	
}
