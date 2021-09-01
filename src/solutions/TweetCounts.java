package solutions;

import java.util.*;

/**
 * 1348 Tweet Counts Per Frequency
 */
public class TweetCounts {
    Map<String, TreeMap<Integer,Integer>> tweetToMap;

    public TweetCounts() {
        tweetToMap = new HashMap<>();
    }

    //time O(log N)
    public void recordTweet(String tweetName, int time) {
        if(!tweetToMap.containsKey(tweetName)){
            tweetToMap.put(tweetName, new TreeMap<>());
        }
        TreeMap<Integer,Integer> timeToFreq = tweetToMap.get(tweetName);

        timeToFreq.put(time, timeToFreq.getOrDefault(time, 0) + 1);
    }
    // time O(logN + k) k is number of entrys within[startTime endTime]
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        if(!tweetToMap.containsKey(tweetName)){
            return result;
        }

        int interval = 60;
        if(freq.equals("hour")){
            interval = 3600;
        }else if(freq.equals("day")){
            interval = 86400;
        }

        // tweet exists, init each interval freqnecy as zero
        int numIntervals = (endTime - startTime) / interval + 1;
        int[] interFreqs = new int[numIntervals];
        // get a range within [startTime, endTime] with time O(logN + N)
        Map<Integer, Integer> range = tweetToMap.get(tweetName).subMap(startTime, true, endTime, true);
        for(int timeStamp : range.keySet()){
            // get interval index
            int idx = (timeStamp - startTime) / interval;
            interFreqs[idx] += range.get(timeStamp);
        }

        for(int interFreq: interFreqs){
            result.add(interFreq);
        }
        return result;
    }
}
