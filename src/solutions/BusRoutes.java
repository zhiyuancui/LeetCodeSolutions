package solutions;

import java.util.*;

/**
 * 815 Bus Routes
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < routes.length; i++) {
            Arrays.sort(routes[i]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> targets = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < routes.length; i++) {
            for(int j = i+1; j < routes.length; j++) {
                if(isConnected(routes, i, j)) {
                    List<Integer> list1 = graph.getOrDefault(i, new ArrayList<>());
                    List<Integer> list2 = graph.getOrDefault(j, new ArrayList<>());

                    list1.add(j);
                    list2.add(i);

                    graph.put(i, list1);
                    graph.put(j, list2);
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            for(int j : routes[i]) {
                if(j == source) {
                    visited.add(i);
                    queue.add(i);
                }

                if(j == target) {
                    targets.add(i);
                }
            }
        }

        int step = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for(int i = 0; i < size; i++) {
                int cur = queue.poll();
                if(targets.contains(cur)) {
                    return step;
                }
                if(graph.containsKey(cur)){
                    for(int next: graph.get(cur)) {
                        if(!visited.contains(next)){
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
        }

        return -1;
    }


    private boolean isConnected(int[][] routes, int i, int j) {
        int m = 0, n = 0;

        while(m < routes[i].length && n < routes[j].length) {
            if(routes[i][m] == routes[j][n]) {
                return true;
            }
            if(routes[i][m] < routes[j][n]) {
                m++;
            } else {
                n++;
            }
        }

        return false;
    }

}
