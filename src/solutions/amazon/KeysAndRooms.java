package solutions.amazon;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(int next: rooms.get(node)) {
                if(!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }

        for(boolean v : visited) {
            if(!v) return false;
        }

        return true;
    }
}
