package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 266 Palindrome Permutation
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		if(s == null || s.length() == 0) {
			return false;
		}

		Map<Character, Integer> map = new HashMap<>();

		for(char c : s.toCharArray()) {
			int count = map.getOrDefault(c,0)+1;
			map.put(c, count);
		}

		boolean single = false;
		for(char key : map.keySet()) {
			if(map.get(key) % 2 == 1 ) {
				if(single) {
					return false;
				} else {
					single = true;
				}
			}
		}

		return true;
	}
}
