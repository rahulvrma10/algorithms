package Algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConnectedCell {
//1. Find the number of islands in this matrix
//2. find the max region covered in this matrix

	static int[][] matrix =  {
			{0,0,1,0}, 
			{1,0,1,1},
			{1,0,1,0},
			{1,0,0,0},
	} ;
	
	


	private static int getRegionAround(int row, int col, int[][] matrix2) {
		//boundary checks to return no size when found 0 or when recursive function is out of bounds
	
		
		
		int size = 1 ; 
		//check up-down-left-right for a 1 that might be connected to this [row,col]
	
		return size ;
	}
	
	
	
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>() ;
		
		//traverse each cell 
		for(int row = 0 ; row < matrix.length ; row ++) {
			for(int col = 0 ; col < matrix[row].length ; col ++){
				
				//look if we find a 1 (shore of island) 
				if(matrix[row][col] == 1) {
					int size = getRegionAround(row,col,matrix) ;  //explore region around this 1
					list.add(size);
				}
			}
		}
		
		
		Collections.sort(list);
		System.out.println("Number of regions "  +list.size());
		System.out.println("Max rigion coverage "  +list.get(list.size()-1));
		

	}





}
