import java.util.HashMap;
import java.util.*;

class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        if(students == null || mentors == null) {
            return 0;
        }

        Map<Integer, Integer> studentsMap = new HashMap<>();
        Map<Integer, Integer> mentorsMap = new HashMap<>();

        for(int i = 0; i < students.length; i++) {
            int code = encode(students[i]);
            studentsMap.put(i, code);
        }

        for(int i = 0; i < mentors.length; i++) {
            int code = encode(mentors[i]);
            mentorsMap.put(i, code);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> {
            int[] res1 = findBestMatch(a, mentorsMap);
            int[] res2 = findBestMatch(b, mentorsMap);

            return res2[0] - res1[0];
        });

        for(int student : studentsMap.keySet()) {
            queue.add(student);
        }

        Set<Integer> visited = new HashSet<>();

        int max = 0;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            int[] score = findBestMatch(studentsMap.get(cur), mentorsMap);
            if(!visited.contains(score[1])) {
                max += score[0];
                visited.add(score[1]);
                mentorsMap.remove(score[1]);
            } else {
                queue.add(cur);
            }
        }

        return max;

    }

    private int[] findBestMatch(int code, Map<Integer, Integer> mentorsMap) {
        int score = 0;
        int idx = -1;
        for(int mentor : mentorsMap.keySet()) {
            if(cal(code, mentorsMap.get(mentor)) > score) {
                score = cal(code, mentorsMap.get(mentor));
                idx = mentor;
            }
        }

        return new int[]{score, idx};
    }

    private int cal(int a, int b) {
        return (a^b)^1;
    }

    private int encode(int[] nums) {

        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            result |= nums[i] << (nums.length - i - 1);
        }

        return result;
    }
}