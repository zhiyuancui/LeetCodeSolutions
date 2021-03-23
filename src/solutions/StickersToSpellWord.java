package solutions;

import java.util.HashMap;
import java.util.*;

public class StickersToSpellWord {
    public int minStickers(String[] stickers, String target) {
        if(target == null || stickers == null) {
            return -1;
        }

        HashMap<Character, Set<String>> map = new HashMap<>();
        for(int i = 0; i < stickers.length; i++) {
            for(char c : stickers[i].toCharArray()) {
                if(!map.containsKey(c)) {
                    map.put(c, new HashSet<>());
                }
                map.get(c).add(stickers[i]);
            }
        }

        int levels = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(target);

        boolean isFound = false;

        while(!queue.isEmpty()) {
            int size = queue.size();
            Set<String> distinctNewWords = new HashSet<>();
            for(int i=0; i < size; i++) {
                String top = queue.remove();
                if(top.equals("")) {
                    isFound = true;
                    break;
                }

                if(map.get(top.charAt(0)) == null) {
                    return -1;
                }

                Set<String> neighbors = map.get(top.charAt(0));
                for(String n : neighbors) {
                    distinctNewWords.add(getString(top, n));
                }
            }
            for(String s : distinctNewWords) {
                queue.add(s);
            }

            if(isFound) {
                break;
            }
            levels++;
        }

        return levels;
    }

    private String getString(String mainStr, String str) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(map.get(str.charAt(i)) == null) {
                map.put(str.charAt(i), 0);
            }
            map.put(str.charAt(i), map.get(str.charAt(i)) +1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mainStr.length(); i++) {
            if(map.containsKey(mainStr.charAt(i))) {
                map.put(mainStr.charAt(i), map.get(mainStr.charAt(i)) - 1);
                if(map.get(mainStr.charAt(i)) == 0) {
                    map.remove(mainStr.charAt(i));
                }
            } else {
                sb.append(mainStr.charAt(i));
            }
        }

        return sb.toString();
    }

}
