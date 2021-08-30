package solutions.robinhood;

import java.util.*;

/**
 * Reference to https://www.1point3acres.com/bbs/thread-791029-1-1.html
 */
public class ResourceLog {
    public Map<String, List<Integer>> getUserMinMaxAccessTime(String[][] logs) {
        Map<String, List<Integer>> result = new HashMap<>();
        for(String[] log : logs) {
            String user = log[1];
            Integer time = Integer.parseInt(log[0]);
            String resource = log[2];

            List<Integer> list = result.getOrDefault(user, new ArrayList<>());

            if(!list.isEmpty()) {
                list.set(0, Math.min(time, list.get(0)));
                list.set(1, Math.max(time, list.get(1)));
            } else {
                list.add(time);
                list.add(time);
            }

            result.put(user, list);
        }

        return result;
    }

    public Map<String, Integer> findResourcesInWindow(String[][] logs) {
        Map<String, List<Integer>> resToTime = new HashMap<>();
        for (String[] log : logs) {
            Integer time = Integer.parseInt(log[0]);
            String resource = log[2];
            List<Integer> timeSlots = resToTime.getOrDefault(resource, new ArrayList<>());
            timeSlots.add(time);
            resToTime.put(resource, timeSlots);
        }

        Map<String, Integer> result = new HashMap<>();

        String resName = "";
        int count = 0;

        for(String resource : resToTime.keySet()) {
            List<Integer> times = resToTime.get(resource);
            Collections.sort(times);

            for (int i = 0; i < times.size(); i++) {
                int j = i;
                while (j < times.size() && times.get(j) - times.get(i) <= 300) {
                    if (j - i + 1 > count) {
                        count = j - i + 1;
                        resName = resource;
                    }
                    j++;
                }
            }
        }

        result.put(resName, count);
        return result;
    }

    public static void main(String[] args) {
        ResourceLog r = new ResourceLog();
        String[][] logs = new String[][]{
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };
        System.out.println("Q1:");
        System.out.println(r.getUserMinMaxAccessTime(logs));
        System.out.println();

        String[][] logs2= new String[][]{
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };
        System.out.println("Q2:");
        System.out.println(r.findResourcesInWindow(logs));
        System.out.println(r.findResourcesInWindow(logs2));
        System.out.println();
    }
}
