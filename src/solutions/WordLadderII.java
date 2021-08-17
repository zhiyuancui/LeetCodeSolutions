package solutions;

import java.util.*;

/**
 * 126 Word Ladder II
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        // 利用 BFS 得到所有的邻居节点,以及每个节点的所在层数
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, Set<String>> map = new HashMap<>();
        bfs(beginWord, endWord, wordList, map, distance);
        List<String> temp = new ArrayList<String>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        findLaddersHelper(beginWord, endWord, map, temp, ans);
        return ans;
    }

    private void findLaddersHelper(String beginWord, String endWord, HashMap<String, Set<String>> map,
                                   List<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            ans.add(new ArrayList<String>(temp));
            return;
        }

        Set<String> neighbors = map.getOrDefault(beginWord, new HashSet<String>());
        for (String neighbor : neighbors) {
            temp.add(neighbor);
            findLaddersHelper(neighbor, endWord, map,  temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, HashMap<String, Set<String>> map,
                    HashMap<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                // 一次性得到所有的下一个的节点
                ArrayList<String> neighbors = getNeighbors(temp, dict);
                //map.put(temp, neighbors);
                for (String neighbor : neighbors) {
                    if (!distance.containsKey(neighbor) || distance.get(neighbor) == depth) {
                        Set<String> next = map.getOrDefault(temp, new HashSet<>());
                        next.add(neighbor);
                        map.put(temp, next);
                        distance.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }

                }
            }
            if (isFound) {
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char[] chs = node.toCharArray();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }
}
