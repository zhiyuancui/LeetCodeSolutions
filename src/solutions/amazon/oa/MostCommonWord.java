package solutions.amazon.oa;


import java.util.*;

/**
 * Time Complexity: loops O(R * W) R is number of reviews, W is number of words in a review + O(NlogN) N is number of keywords
 */
public class MostCommonWord {
    public List<String> mostCommonWord(int k, String[] reviews, String[] keys) {
        Set<String> keySet = new HashSet<>();
        for(String word : keys) {
            keySet.add(word);
        }

        Map<String, Integer> map = new HashMap<>();

        for(String review: reviews) {
            review = review.replaceAll("[^a-zA-Z]", " ").toLowerCase().trim();
            String[] words = review.split("[ ,]+");
            for(String word: words) {
                if(keySet.contains(word)) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        }

        PriorityQueue<String> queue = new PriorityQueue<String>((a,b) -> {
            if(map.get(a) == map.get(b)) {
                return a.compareTo(b);
            } else {
                return map.get(a) - map.get(b);
            }
        });

        for(String word: map.keySet()) {
            queue.offer(word);
            if(queue.size() > k) {
                queue.poll();
            }
        }

        List<String> result = new ArrayList<>();

        while(queue.size() > 0) {
            result.add(queue.poll());
        }
        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        MostCommonWord solution = new MostCommonWord();
        String[] reviews = new String[]{
                "..........................",
        };
        String[] keywords = new String[]{"anacell", "betacellular", "cetracular", "deltacellular", "eurocell"};
        List<String> result = solution.mostCommonWord(2, reviews, keywords);

        for(String s : result){
            System.out.println(s);
        }
    }
}