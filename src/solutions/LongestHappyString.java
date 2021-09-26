package solutions;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", a);
        map.put("b", b);
        map.put("c", c);

        PriorityQueue<String> queue = new PriorityQueue<String>((x, y) -> map.get(x) - map.get(y));

        while(true) {
            queue.add("a");
            queue.add("b");
            queue.add("c");

            String first = queue.poll();
            String second = queue.poll();
            String third = queue.poll();

            if(sb.length() >= 2 &&
                    sb.charAt(sb.length() - 1) == third.charAt(0) &&
                    sb.charAt(sb.length() - 2) == third.charAt(0)
            ) {
                if(map.get(second) > 0) {
                    sb.append(second);
                    map.put(second, map.get(second)-1);
                } else {
                    break;
                }
            } else {
                if(map.get(third)> 0) {
                    map.put(third, map.get(third)-1);
                    sb.append(third);
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
