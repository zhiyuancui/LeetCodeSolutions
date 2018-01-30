package solutions;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap <K,V>{

	class Entry{
		K key;
		V value;
		Entry next;
		public Entry( K k, V v ) {
			key = k;
			value = v;
			next = null;
		}
	}
	
	List<Entry> array;
	int capacity;
	public MyHashMap( int capacity ) {
		array = new ArrayList<>();
	}
	
	public void put( K key, V value ) {
		Entry cur = new Entry( key, value );
		int code = key.hashCode();
		if( array.get(code) == null ) {
			array.add( cur );
			return;
		} else {
			Entry head = array.get(code);
			while( head.next != null ) {
				if( head.key == key ){
					head.value = value;
					break;
				} else {
					head = head.next;
				}
			}
			if( head.next == null ) {
				if( head.key == key ) {
					head.value = value;
				} else{
					head.next = cur;
				}
			}
		}
	}
	
	public V get( K key ) {
		int index = key.hashCode();
		if( array.get(index) == null ) {
			return null;
		} else {
			Entry head = array.get(index);
			if( head.key == key ) {
				return head.value;
			}
			while( head.next != null ) {
				if( head.key == key ){
					return head.value;
				}
			}
			return null;
		}
	}
}
