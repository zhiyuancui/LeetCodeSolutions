package solutions;

import java.util.TreeSet;

public class ExamRoom {
    int total;
    TreeSet<Integer> students;
    public ExamRoom(int N) {
        total = N;
        students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if(students.size() > 0) {
            int dist = students.first();// 第一个student和0的距离
            Integer prev = null;
            for(Integer s: students) {
                if(prev != null) {
                    int cur = (s - prev) / 2;
                    if(cur > dist) {
                        dist = cur;
                        student = prev + dist;
                    }
                }
                prev = s;
            }
            if(total - 1 - students.last() > dist) {
                student =  total - 1;
            }
        }

        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }
}
