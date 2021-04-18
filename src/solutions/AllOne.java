package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {

    class Bucket {
        int count;
        Set<String> set;
        Bucket prev;
        Bucket next;

        public Bucket(int c) {
            count = c;
            set = new HashSet<>();
        }
    }

    Bucket head;
    Bucket tail;
    Map<Integer, Bucket> countBucketMap;
    Map<String, Integer> keyMap;
    /** Initialize your data structure here. */
    public AllOne() {
        head = new Bucket(0);
        tail = new Bucket(0);

        head.next = tail;
        tail.prev = head;

        countBucketMap = new HashMap<>();
        keyMap = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(keyMap.containsKey(key)) {
            int count = keyMap.get(key);
            keyMap.put(key, count+1);

            Bucket cur = countBucketMap.get(count);
            cur.set.remove(key);
            if(cur.next.count == count + 1) {
                cur.next.set.add(key);
            } else {
                addBucketAfter(new Bucket(count+1), cur);
                countBucketMap.put(count+1, cur.next);
                Bucket next = countBucketMap.get(count+1);
                next.set.add(key);
            }

            if(cur.set.isEmpty()) {
                removeBucket(cur);
                countBucketMap.remove(count);
            }


        } else {
            keyMap.put(key, 1);
            if(head.next.count == 1) {
                head.next.set.add(key);
            } else {
                addBucketAfter(new Bucket(1), head);
                countBucketMap.put(1, head.next);
                Bucket cur = countBucketMap.get(1);
                cur.set.add(key);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int count = keyMap.get(key);
        if(count == 1) {
            keyMap.remove(key);
            Bucket cur = countBucketMap.get(count);
            cur.set.remove(key);
            if(cur.set.isEmpty()) {
                removeBucket(cur);
                countBucketMap.remove(count);
            }
        } else {
            keyMap.put(key, count-1);
            Bucket cur = countBucketMap.get(count);
            cur.set.remove(key);
            if(cur.prev.count == count-1) {
                Bucket prev = cur.prev;
                prev.set.add(key);
            } else {
                Bucket prev = new Bucket(count -1);
                countBucketMap.put(count-1, prev);
                addBucketAfter(prev, cur.prev);
                prev.set.add(key);
            }
            if(cur.set.isEmpty()) {
                removeBucket(cur);
                countBucketMap.remove(count);
            }
        }

        //printBucket(head.next);
    }

    /** Returns one of the keys with maximal value. */
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        printBucket(head.next);
        return tail.prev == head ? "" : (String) tail.prev.set.iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.set.iterator().next();
    }

    private void removeBucket(Bucket b) {
        b.prev.next = b.next;
        b.next.prev = b.prev;
    }

    private void addBucketAfter(Bucket cur, Bucket prev) {
        cur.next = prev.next;
        prev.next.prev = cur;
        prev.next = cur;
        cur.prev = prev;
    }

    private void printBucket(Bucket cur) {
        while(cur != tail) {
            System.out.println("count: " + cur.count);
            for(String key: cur.set) {
                System.out.println("("+key+","+(keyMap.containsKey(key)? keyMap.get(key): 0)+")");
            }
            System.out.println("-------------------------");
            cur = cur.next;
        }
        System.out.println("////////////////////////////");
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */