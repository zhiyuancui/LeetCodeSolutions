package solutions;

import java.util.*;

/**
 * 451 Sort Characters By Frequency
 */
public class FrequencySort {

	public String frequencySort(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}

		Map<Character, Integer> map = new HashMap<>();

		for(char c : s.toCharArray()) {
			int count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
		}

		PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

		for(char c : map.keySet()) {
			queue.add(c);
		}

		StringBuilder sb = new StringBuilder();

		while(!queue.isEmpty()) {
			char c = queue.poll();

			int time = map.get(c);
			for(int i = 0; i < time; i++) {
				sb.append(c);
			}
		}

		return sb.toString();
	}
}
