package solutions.compass;

import java.util.*;

/**
 * https://www.jianshu.com/p/fdbcba5fe5bc
 */
public class CourseOverlap {
    public void courseOverlaps(String[][] studentCoursePairs) {
        if(studentCoursePairs == null || studentCoursePairs.length == 0) {
            return;
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for(String[] pair : studentCoursePairs) {
            List<String> list = map.getOrDefault(pair[0], new ArrayList<>());

            list.add(pair[1]);
            map.put(pair[0], list);
        }

        List<String> students = new ArrayList<>(map.keySet());

        for(int i = 0; i < students.size(); i++) {
            for(int j = i +1; j < students.size(); i++) {
                List<String> overlaps = new ArrayList<>();

                for(String course1 : map.get(students.get(i))) {
                    for(String course2 : map.get(students.get(j))) {
                        if(course1.equals(course2)) {
                            overlaps.add(course1);
                        }
                    }
                }
            }
        }
    }
}
