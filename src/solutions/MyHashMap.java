package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

	class Node {
		int key;
		int value;
		Node next;

		public Node(int k, int v) {
			key = k;
			value = v;
			next = null;
		}
	}

	List<Node> buckets = new ArrayList<>();
	/** Initialize your data structure here. */
	public MyHashMap() {
		for(int i = 0; i < capacity; i++) {
			buckets.add(new Node(0,0));
		}
	}

	int capacity = 100;

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = key % capacity;

		Node head = buckets.get(index);

		while(head != null && head.next != null) {
			if(head.next.key == key) {
				break;
			}
			head = head.next;
		}

		if(head.next == null) {
			Node next = new Node(key, value);
			head.next = next;
		} else {
			head.next.key = key;
			head.next.value = value;
		}

	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {
		int index = key % capacity;

		Node head = buckets.get(index);

		head = head.next;

		while(head != null) {
			if(head.key == key) {
				return head.value;
			}
			head = head.next;
		}

		return -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int index = key % capacity;

		Node head = buckets.get(index);

		while(head != null && head.next != null) {
			if(head.next.key == key) {
				break;
			}
			head = head.next;
		}

		if(head.next != null) {
			head.next = head.next.next;
		}

	}
}
