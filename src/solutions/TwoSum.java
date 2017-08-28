package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
        	int complement = target - nums[i];
        	if (map.containsKey(complement) && map.get(complement) != i) {
        		return new int[] { i, map.get(complement) };
        	}
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
	private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
	        int num1 = list.get(i), num2 = value - num1;
	        if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
	    }
	    return false;
	}
	
}
