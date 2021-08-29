package solutions.amazon;

import util.Interval;

import java.util.*;

/**
 * 759 Employee Free Time
 */
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result =  new ArrayList<>();

        Queue<Interval> queue = new PriorityQueue<Interval>((a, b) -> a.start - b.start);

        for(List<Interval> list : schedule) {
            queue.addAll(list);
        }

        Interval cur = queue.poll();

        while(!queue.isEmpty()) {
            if(cur.end < queue.peek().start) {
                result.add(new Interval(cur.end, queue.peek().start));
                cur = queue.poll();
            } else {
                cur.end = Math.max(cur.end, queue.poll().end);
            }
        }
        return result;
    }
}
