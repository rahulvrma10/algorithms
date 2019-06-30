package dataStructure;

import java.util.Arrays;

public class MyArrayList<K> {

	
	private Object[] list ; 
	private final int INIT_CAPACITY = 1; 
	private int size = 0  ; 
	
	MyArrayList(){
		this.list = new Object[INIT_CAPACITY] ; 
	}
	
	public int size() {
		return this.size ; 
	}
	
	public void add(K element){
		
		ensureExtraCapacity() ; 
		list[size] = element ; 
		size ++  ; 
	}
	
	
	void ensureExtraCapacity(){
		if(size == list.length) {
			list = Arrays.copyOf(list, list.length + 10) ; 
		}
	}
	public boolean remove(int index ) {
		
		if(index > size -1 ) {
			throw new RuntimeException("ArrayIndexOutOfBound");
		}
		
	
		//reshuffle
		for(int i = index ; i < size-1 ; i ++  ) {
			list[i] = list[i+1];
		}
		size -- ;
		return true;
		
	}
	
	public K get(int index) {
		return (K)list[index] ; 
	}
	public static void main(String[] args) {

		MyArrayList<Integer> mList  = new MyArrayList<Integer> () ;
		mList.add(0);
		mList.add(1);
		mList.add(2);
		
		System.out.println(mList.get(0));
		mList.remove(1);
		System.out.println(mList.get(1));
		System.out.println(mList.size());
		System.out.println(mList.list.length);
		
		
		
		
	}
}
