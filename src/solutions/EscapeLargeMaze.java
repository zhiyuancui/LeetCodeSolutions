package solutions;

import java.util.*;

public class EscapeLargeMaze {
    int mapMax = 100000;
    int maxStep = 0;
    Set<Point> blockedSet = new HashSet<>();

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked == null || blocked.length < 2) {
            return true;
        }

        for(int[] point: blocked) {
            blockedSet.add(new Point(point[0], point[1]));
        }

        maxStep = (blocked.length - 1) * blocked.length / 2;

        return bfs(source, target) && bfs(target, source);
    }


    public boolean bfs(int[] src, int[] tar) {
        Point source = new Point(src[0], src[1]);
        Point target = new Point(tar[0], tar[1]);

        Set<Point> accessSet = new HashSet<>();
        Queue<Point> queue = new LinkedList<>();

        queue.add(source);


        while(!queue.isEmpty()) {
            int size = queue.size();

            if(accessSet.size() > maxStep) {
                return true;
            }

            for(int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if(cur.x == target.x && cur.y == target.y) {
                    return true;
                } else {
                    if (cur.y + 1 < mapMax) {
                        addToQueue(queue, accessSet, new Point(cur.x, cur.y + 1));
                    }
                    if (cur.x + 1 < mapMax) {
                        addToQueue(queue, accessSet, new Point(cur.x + 1, cur.y));
                    }
                    if (cur.y - 1 > -1) {
                        addToQueue(queue, accessSet, new Point(cur.x, cur.y - 1));
                    }
                    if (cur.x - 1 > -1) {
                        addToQueue(queue, accessSet, new Point(cur.x - 1, cur.y));
                    }
                }
            }
        }

        return false;
    }

    void addToQueue(Queue<Point> queue, Set<Point> accessSet, Point point) {
        if (!blockedSet.contains(point) && !accessSet.contains(point)) {
            queue.add(point);
            accessSet.add(point);
        }
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Point)) return false;

            Point p = (Point)o;
            return x == p.x && y == p.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
