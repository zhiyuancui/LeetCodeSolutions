package solutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Entry<U, V> {
	public U key;
	public V value;

	public Entry(U key, V value) {
		this.key = key;
		this.value = value;
	}
}


class Bucket {
	private List<Entry<Integer, Integer>> bucket;

	public Bucket() {
		this.bucket = new LinkedList<Entry<Integer, Integer>>();
	}

	public Integer get(Integer key) {
		for (Entry<Integer, Integer> entry : this.bucket) {
			if (entry.key.equals(key))
				return entry.value;
		}
		return -1;
	}

	public void update(Integer key, Integer value) {
		boolean found = false;
		for (Entry<Integer, Integer> entry : this.bucket) {
			if (entry.key.equals(key)) {
				entry.value = value;
				found = true;
			}
		}
		if (!found)
			this.bucket.add(new Entry<Integer, Integer>(key, value));
	}

	public void remove(Integer key) {
		for (Entry<Integer, Integer> entry : this.bucket) {
			if (entry.key.equals(key)) {
				this.bucket.remove(entry);
				break;
			}
		}
	}
}

class MyHashMap {
	private int key_space;
	private List<Bucket> hash_table;

	/** Initialize your data structure here. */
	public MyHashMap() {
		this.key_space = 2069;
		this.hash_table = new ArrayList<Bucket>();
		for (int i = 0; i < this.key_space; ++i) {
			this.hash_table.add(new Bucket());
		}
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int hash_key = key % this.key_space;
		this.hash_table.get(hash_key).update(key, value);
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
	 * for the key
	 */
	public int get(int key) {
		int hash_key = key % this.key_space;
		return this.hash_table.get(hash_key).get(key);
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {
		int hash_key = key % this.key_space;
		this.hash_table.get(hash_key).remove(key);
	}
}
