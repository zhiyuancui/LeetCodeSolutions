package solutions.doordash;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-798058-1-1.html
 * O(NlogK + M*N)
 */
public class NearestCity {

    class Choice {
        String name;
        int distance;

        public Choice(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }

    public List<String> closestStraightCity(String[] citys, int[] xs, int[] ys, String[] queryCitys) {
        Map<String, int[]> cityMap = new HashMap<>();

        Map<Integer, TreeMap<Integer, String>> xMap = new HashMap<>();
        Map<Integer, TreeMap<Integer, String>> yMap = new HashMap<>();

        int n = citys.length;

        for(int i = 0; i < n; i++) {
            int x = xs[i];
            int y = ys[i];
            String cityName = citys[i];

            xMap.computeIfAbsent(x, k -> new TreeMap<>());
            if(!xMap.get(x).containsKey(y) || cityName.compareTo(xMap.get(x).get(y)) < 0) {
                xMap.get(x).put(y, cityName);
            }

            yMap.computeIfAbsent(y, k -> new TreeMap<>());
            if(!yMap.containsKey(x) || cityName.compareTo(yMap.get(y).get(x)) < 0) {
                yMap.get(y).put(x, cityName);
            }

            cityMap.put(cityName, new int[]{x, y});
        }

        List<String> result = new ArrayList<>();
        for(String city: queryCitys) {
            int x = cityMap.get(city)[0];
            int y = cityMap.get(city)[1];

            List<Choice> choices = new ArrayList<>();

            collect(xMap, x, y, choices);
            collect(yMap, y, x, choices);

            Collections.sort(choices, (a,b) -> {
                if(a.distance == b.distance) {
                    return a.name.compareTo(b.name);
                } else {
                    return a.distance - b.distance;
                }
            });

            if(choices.isEmpty()) {
                result.add("None");
            } else {
                result.add(choices.get(0).name);
            }
        }

        return result;
    }

    public void collect(Map<Integer, TreeMap<Integer, String>> line, int point, int value, List<Choice> choices) {
        if(line.get(point) != null) {
            Map.Entry<Integer, String> high = line.get(point).higherEntry(value);
            Map.Entry<Integer, String> low = line.get(point).lowerEntry(value);

            if(high != null) {
                choices.add(new Choice(high.getValue(), high.getKey() - value));
            }
            if(low != null) {
                choices.add(new Choice(low.getValue(), value - low.getKey()));
            }
        }
    }
}
