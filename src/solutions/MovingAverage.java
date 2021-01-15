package solutions;

import java.util.Deque;
import java.util.LinkedList;

public class MovingAverage {
    Deque<Integer> queue;
    int size = 0;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        queue.add(val);
        if(queue.size() > size) {
            queue.removeFirst();
        }

        int sum = 0;
        for(int i : queue) {
            sum += i;
        }

        return sum / (double)queue.size();
    }
}
