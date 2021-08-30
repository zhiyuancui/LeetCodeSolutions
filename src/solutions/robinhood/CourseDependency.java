package solutions.robinhood;

import java.util.*;

/**
 * Reference to https://www.1point3acres.com/bbs/thread-791029-1-1.html
 */
public class CourseDependency {
    public String findMedianCourseI(String[][] courses) {
        Map<String, String> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for(String[] course : courses) {
            graph.put(course[0], course[1]);

            int degree = indegree.getOrDefault(course[0], 0);
            indegree.put(course[0], degree);

            degree = indegree.getOrDefault(course[1], 0) + 1;
            indegree.put(course[1], degree);
        }

        List<String> path = new ArrayList<>();
        for(String course : graph.keySet()) {
            if(indegree.get(course) == 0) {
                while(course != null) {
                    path.add(course);
                    course = graph.get(course);
                }
            }
        }

        return path.get((path.size() - 1 ) /2);

    }

    public List<String> findMedianCourseII(String[][] courses) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();

        for(String[] course : courses) {
            List<String> list = graph.getOrDefault(course[0], new ArrayList<>());
            list.add(course[1]);
            graph.put(course[0], list);

            int degree = indegree.getOrDefault(course[0], 0);
            indegree.put(course[0], degree);

            degree = indegree.getOrDefault(course[1], 0) + 1;
            indegree.put(course[1], degree);
        }

        Set<String> result = new HashSet<>();

        for (String course : indegree.keySet()) {
            if (indegree.get(course) == 0) {
                List<String> path = new ArrayList<>();
                backtrack(graph, course, path, result);
            }
        }

        return new ArrayList<>(result);
    }

    private void backtrack(Map<String, List<String>> graph, String course, List<String> path, Set<String> result) {
        path.add(course);

        if(!graph.containsKey(course) || graph.get(course).isEmpty()) {
            int midIndex = (path.size() - 1) / 2;
            String midCourse = path.get(midIndex);
            result.add(midCourse);
            return;
        }

        for(String next : graph.get(course)) {
            backtrack(graph, next, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CourseDependency c = new CourseDependency();
        String[][] solution1 = new String[][]{{"Course1","Course2"},{"Course3", "Course4"}};
        System.out.println(c.findMedianCourseI(solution1));

        System.out.println("Question 2: ");
        String[][] courseList = new String[][]{
                {"Course_3", "Course_7"},
                {"Course_1", "Course_2"},
                {"Course_2", "Course_3"},
                {"Course_3", "Course_4"},
                {"Course_4", "Course_5"},
                {"Course_5", "Course_6"},
                {"Course_6", "Course_7"}
        };
        String[][] courseList2 = new String[][] {
                {"Logic", "COBOL"},
                {"Data Structures", "Algorithms"},
                {"Creative Writing", "Data Structures"},
                {"Algorithms", "COBOL"},
                {"Intro to Computer Science", "Data Structures"},
                {"Logic", "Compilers"},
                {"Data Structures", "Logic"},
                {"Graphics", "Networking"},
                {"Networking", "Algorithms"},
                {"Creative Writing", "System Administration"},
                {"Databases", "System Administration"},
                {"Creative Writing", "Databases"},
                {"Intro to Computer Science", "Graphics"}
        };
        System.out.println(c.findMedianCourseII(courseList));
        System.out.println(c.findMedianCourseII(courseList2));
    }
}
