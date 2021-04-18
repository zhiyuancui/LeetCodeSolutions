package solutions;

import java.util.*;

public class RandomizedCollection {
	List<Integer> nums;
	Map<Integer, Set<Integer>> map;
	Random rand = new Random();

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		nums = new ArrayList<>();
		map = new HashMap<>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		if(map.containsKey(val)) {
			int idx = nums.size();
			map.get(val).add(idx);
			nums.add(val);
			return false;
		} else {
			int idx = nums.size();
			nums.add(val);
			map.put(val, new LinkedHashSet<Integer>());
			map.get(val).add(idx);
			return true;
		}
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if(!map.containsKey(val)) {
			return false;
		} else {
			int old = map.get(val).iterator().next();
			map.get(val).remove(old);

			if(old < nums.size() -1) {
				int last = nums.get(nums.size() -1);

				nums.set(old, last);
				map.get(last).remove(nums.size()-1);
				map.get(last).add(old);
			}

			nums.remove(nums.size() -1);

			if(map.get(val).isEmpty()) {
				map.remove(val);
			}

			return true;
		}
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get( rand.nextInt(nums.size()) );
	}
}
