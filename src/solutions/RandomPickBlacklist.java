package solutions;

import java.util.*;

public class RandomPickBlacklist {
    Random random = new Random();
    Set<Integer> blackSet = new HashSet<>();
    Map<Integer, Integer> whiteMap = new HashMap<>();
    int range;

    public RandomPickBlacklist (int N, int[] blacklist) {
        int len = blacklist.length;
        int width = N - len;

        range = width;

        for(int num : blacklist) {
            if(num >= width) {
                blackSet.add(num);
            }
        }

        int j = width;
        for(int num : blacklist) {
            if(num < width) {
                while(blackSet.contains(j)) {
                    j++;
                }
                whiteMap.put(num, j);
                j++;
            }
        }
    }

    public int pick() {
        int key = random.nextInt(range);
        return whiteMap.getOrDefault(key, key);
    }

    // 会超时的解法
//    Random random = new Random();
//    Set<Integer> blackSet = new HashSet<>();
//    Map<Integer, Integer> whiteMap = new HashMap<>();
//    int range;
//
//    public Solution(int N, int[] blacklist) {
//        int len = blacklist.length;
//        int width = N - len;
//
//        range = width;
//
//        for(int num : blacklist) {
//            blackSet.add(num);
//        }
//
//        int available = width;
//
//        for(int i = 0; i < range; i++) {
//            if(blackSet.contains(i)) {
//                while(blackSet.contains(available)) {
//                    available++;
//                }
//                whiteMap.put(i, available);
//                available++;
//            }
//        }
//    }
//
//    public int pick() {
//        int key = random.nextInt(range);
//        return whiteMap.getOrDefault(key, key);
//    }
}
