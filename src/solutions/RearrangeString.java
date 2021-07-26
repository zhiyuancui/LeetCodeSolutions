package solutions;

import java.util.*;

/**
 * 358 Rearrange String k Distance Apart
 */
public class RearrangeString {
    public String rearrangeString(String s, int k) {
        if(s == null || k < 0) {
            return "";
        }

        if(k == 0) {
            return s;
        }

        char[] arr = s.toCharArray();
        int n = arr.length;

        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int i = 0; i < n; i++) {
            char c = arr[i];
            int count = map.getOrDefault(c,0) + 1;
            map.put(c, count);
        }

        for(char key: map.keySet()) {
            queue.add(key);
        }

        Deque<Character> deque = new ArrayDeque<>(k);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            if(queue.size() == 0) {
                return "";
            }
            char c = queue.remove();
            sb.append(c);
            int newVal = map.get(c) - 1;
            map.put(c, newVal);

            deque.offer(c);
            if(deque.size() == k) {
                char cur = deque.poll();
                if (map.get(cur) > 0) {
                    queue.add(cur);
                }
            }
        }

        return sb.toString();
    }
}
