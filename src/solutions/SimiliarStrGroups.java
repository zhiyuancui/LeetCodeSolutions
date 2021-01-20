package solutions;

import java.util.*;

public class SimiliarStrGroups {
    public int numSimilarGroups(String[] strs) {
        if(strs == null) {
            return 0;
        }

        Map<String, List<String>> graph = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            for(int j = 0;  j< i; j++) {
                if(isSimilar(strs[i], strs[j])) {
                    List<String> list = graph.getOrDefault(strs[i], new ArrayList<>());
                    list.add(strs[j]);
                    graph.put(strs[i], list);

                    list = graph.getOrDefault(strs[j], new ArrayList<>());
                    list.add(strs[i]);
                    graph.put(strs[j], list);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        int res = 0;
        for(String str: strs) {
            if(!visited.contains(str)) {
                dfs(graph, str, visited);
                res++;
            }
        }

        return res;

    }

    private void dfs(Map<String, List<String>> graph, String src, Set<String> visited) {
        visited.add(src);
        if(!graph.containsKey(src)) {
            return;
        }
        for(String next : graph.get(src)) {
            if(!visited.contains(next)) {
                dfs(graph, next, visited);
            }
        }
    }

    private boolean isSimilar(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != t.charAt(i)) {
                count++;
                if(count > 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
