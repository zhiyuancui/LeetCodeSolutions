package solutions.robinhood;

import java.util.*;

/**
 * Reference to https://www.1point3acres.com/bbs/thread-791029-1-1.html
 */
public class BadgeAccess {

    public List<List<String>> findMismatchedEntries(List<List<String>> records) {
        Set<String> missExit = new HashSet<>();
        Set<String> missEntry = new HashSet<>();

        Map<String, Stack<String>> nameToRecords = new HashMap<>();

        for(List<String> record : records) {
            String name = record.get(0);
            String type = record.get(1);
            Stack<String> entries = nameToRecords.getOrDefault(name, new Stack<>());

            if (type.equals("enter")) {
                entries.push("enter");
            } else {
                if(!entries.isEmpty() && entries.peek().equals("enter")) {
                    entries.pop();
                } else {
                    entries.push("exit");
                }
            }
            nameToRecords.put(name, entries);
        }

        for (String name : nameToRecords.keySet()) {
            Stack<String> entries = nameToRecords.get(name);
            if (!entries.isEmpty()) {
                String entry = entries.pop();
                if(entry.equals("enter")) {
                    missExit.add(name);
                } else {
                    missEntry.add(name);
                }
            }
        }
        return Arrays.asList(new ArrayList(missExit), new ArrayList(missEntry));
    }

    public Map<String, List<String>> findUnusualEntries(List<List<String>> records) {
        Map<String, List<Integer>> nameToEntries = new HashMap<>();
        for (List<String> record : records) {
            String name = record.get(0);
            int time = Integer.parseInt(record.get(1));
            List<Integer> times = nameToEntries.getOrDefault(name, new ArrayList<>());
            times.add(time);
            nameToEntries.put(name, times);
        }

        Map<String, List<String>> unusual = new HashMap<>();

        for(String name: nameToEntries.keySet()) {
            List<Integer> entries = nameToEntries.get(name);
            if(entries.size() < 3) {
                continue;
            }

            Collections.sort(entries);

            for(int i = 0; i < entries.size() - 2; i++) {
                int j = i + 2;
                while (j < entries.size() && entries.get(j) - entries.get(i) >= 0
                        && entries.get(j) - entries.get(i) <= 100) {
                    j++;
                    List<String> timeSlots = unusual.getOrDefault(name, new ArrayList<>());
                    for (int start = i; start < j; start++) {
                        timeSlots.add(Integer.toString(entries.get(start)));
                        unusual.put(name, timeSlots);
                    }
                }
                // only need first time period
                if (unusual.containsKey(name)) {
                    break;
                }
            }
        }
        return unusual;
    }

    public static void main(String[] args) {
        BadgeAccess b = new BadgeAccess();

        // Q1
        System.out.println("Q1: ");
        List<List<String>> badgeRecords = Arrays.asList(
                Arrays.asList("Martha",   "exit"),
                Arrays.asList("Paul",     "enter"),
                Arrays.asList("Martha",   "enter"),
                Arrays.asList("Martha",   "exit"),
                Arrays.asList("Jennifer", "enter"),
                Arrays.asList("Paul",     "enter"),
                Arrays.asList("Curtis",   "enter"),
                Arrays.asList("Paul",     "exit"),
                Arrays.asList("Martha",   "enter"),
                Arrays.asList("Martha",   "exit"),
                Arrays.asList("Jennifer", "exit")
        );

        System.out.println(b.findMismatchedEntries(badgeRecords));

        // Q2
        System.out.println("Q2: ");

        List<List<String>> badgeRecords2 = Arrays.asList(
                Arrays.asList("Paul", "1315"),
                Arrays.asList("Jennifer", "1910"),
                Arrays.asList("John", "830"),
                Arrays.asList("Paul", "1355"),
                Arrays.asList("John", "835"),
                Arrays.asList("Paul", "1405"),
                Arrays.asList("Paul", "1630"),
                Arrays.asList("John", "855"),
                Arrays.asList("John", "915"),
                Arrays.asList("John", "930"),
                Arrays.asList("Jennifer", "1335"),
                Arrays.asList("Jennifer", "730"),
                Arrays.asList("John", "163")
        );

        System.out.println(b.findUnusualEntries(badgeRecords2));
    }
}
