package solutions.stripe;



import java.util.*;

class Request {
    String requestID;

    public Request(int timestamp, String requestID) {
        this.requestID = requestID;
    }
}

public class RateLimiter {

    Map<String, HashSet<Long>> map = new HashMap<>();
    //Map<String, TreeMap<Integer, Integer>> map = new HashMap<>();

    private int threshold;
    private int timeInterval = 2;
    public RateLimiter(int threshold) {
        this.threshold = threshold;
    }

    public boolean isAllowed(Request request) {
        long timestamp = System.currentTimeMillis() / 1000 ;
        if(!map.containsKey(request.requestID) || map.get(request.requestID).isEmpty()) {
            map.put(request.requestID, new HashSet<>());
            map.get(request.requestID).add(timestamp);
            return true;
        }

        //TreeSet solution
        Set<Long> set = map.get(request.requestID);
        Iterator it = set.iterator();

        while(it.hasNext()) {
            int element = (int) it.next();
            if(timestamp - element > timeInterval) {
                it.remove();
            }
        }

        if(set.size() + 1 <= threshold) {
            set.add(timestamp);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter(1);
        int baseTimestamp = 0;
        Random rand = new Random();

        for(int i = 0; i < 20; i++) {
            String id = rand.nextInt(3) + "";
            int flag = rand.nextInt(2);
            if(flag == 0) {
                Request request = new Request(i, id);
                System.out.println("Request: " +id +" At time: " + i +" the request: " + rateLimiter.isAllowed(request));
            }
        }
    }
}
