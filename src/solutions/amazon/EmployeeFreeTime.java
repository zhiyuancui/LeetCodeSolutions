package solutions.amazon;

import util.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();

        PriorityQueue<Interval> queue = new PriorityQueue<>((a,b)->a.start - b.start);
        for (List<Interval> list : schedule) {
            for (Interval interval : list) queue.add(interval);
        }

        if (queue.size() == 0) return result;
        Interval cur = queue.poll();
        int start = cur.start; int end = cur.end;

        while (!queue.isEmpty()) {
            if (queue.peek().start > end) {
                result.add(new Interval(end, queue.peek().start));
                end = queue.peek().end;
            }else {
                end = Math.max (queue.peek().end, end);
            }
            queue.poll();
        }
        return result;
    }
}
