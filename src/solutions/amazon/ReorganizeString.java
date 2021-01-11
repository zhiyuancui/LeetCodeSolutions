package solutions.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public String reorganizeString(String S) {
        if(S == null || S.length() == 0) {
            return "";
        }

        int len = S.length();

        int[] counts = new int[26];

        for(char c : S.toCharArray()) {
            counts[c-'a'] += 100;
        }

        for(int i = 0; i < 26; i++) {
            counts[i] += i;
        }

        Arrays.sort(counts);

        char[] ans = new char[len];

        int t = 1;
        for(int code: counts) {
            int count = code / 100;
            char ch = (char)('a' + (code%100));
            if( count > (len+1)/2) return "";

            for(int i = 0; i < count; i++) {
                if( t >= len) {
                    t = 0;
                }
                ans[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(ans);
    }

    class Node {
        int count;
        char c;
        public Node(int _count, char _c) {
            count = _count;
            c = _c;
        }
    }

    /**
     * Another solution
     * @param S
     * @return
     */
    public String reorganizeString2(String S) {
        if(S == null || S.length() == 0 ) {
            return "";
        }

        int len = S.length();
        char[] res = new char[len];

        Map<Character, Integer> map = new HashMap<>();
        for(char c : S.toCharArray()) {
            int count = map.getOrDefault(c, 0)+1;
            map.put(c, count);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.count - a.count);

        for(char key: map.keySet()) {
            queue.add(new Node(map.get(key), key));
        }

        int idx = 0;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.println(cur.count+","+cur.c);
            char c = cur.c;
            int count = cur.count;
            if(count > (len+1)/2) return "";
            for(int i = 0; i < count; i++) {
                if(idx >= len) {
                    idx = 1;
                }
                res[idx] = c;
                idx += 2;
            }

        }

        return String.valueOf(res);
    }
}
