package dataStructure;

public class MyHashMap<K,V>{


	static class MyLinkedList<K,V>{

		K key ; 
		V value ; 
		MyLinkedList<K,V> next ;

		MyLinkedList(K key , V value){
			this.key = key;
			this.value = value ; 
		}

	}

	private final int INIT_CAPACITY = 16 ; 
	private MyLinkedList<K,V>[] masterIndex ; 

	private int size = 0 ;
	MyHashMap(){
		masterIndex = new MyLinkedList[INIT_CAPACITY] ;
	}


	public void put(K key , V value) {
		int index = hash(key) ; 
		MyLinkedList<K,V> obj = masterIndex[index];
		
		if(obj == null) {
			masterIndex[index] = new MyLinkedList<K,V>(key,value) ; 
			size ++;
			return ; 
		}
		
		while(true) {
			
			//replace if same key
			if(obj.key.equals(key)) {
				obj.value = value ;
				return ; 
			}
			// check if next has no value
			if(obj.next == null) {
				obj.next = new MyLinkedList<K,V>(key,value) ; 
				size++ ;
				return ; 
			}
			obj = obj.next ; 
		}
	}


	private int hash(K key) {
		return key == null ? 0 : key.hashCode() % this.INIT_CAPACITY ;
	}


	private int size() {
		return size ; 
	}
	
	public V get(K key) {
		
		// get the index
		int index = hash(key) ; 
		MyLinkedList<K,V> obj = masterIndex[index];

		while(obj  !=null) {
			if(obj.key==null  || obj.key.equals(key)) {
				return obj.value ; 
			}
			obj = obj.next ;
		}
		
		return  null ;
	}

	public V remove(K key) {
		return null ;
	}



	public static void main(String[] args) {

		MyHashMap<String,String> mHashMap  = new MyHashMap<String,String>() ;
		mHashMap.put("Good", "Rahul");
		mHashMap.put("Good", "Rahul1");
		mHashMap.put("Good", "Rahul2");
		mHashMap.put("Good", "Rahul3");
		mHashMap.put("Bad", "kukum");
		mHashMap.put(null, "nalla");
		
		System.out.println(mHashMap.get(null));
		System.out.println(mHashMap.size());
		
		
	}

}
