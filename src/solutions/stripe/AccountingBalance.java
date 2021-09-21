package solutions.stripe;

import java.util.*;

/**
 * https://www.1point3acres.com/bbs/thread-767545-1-1.html
 * 给定时间和limit，实现rate limiting. 比如，同一个user，2秒内只能call 5次
 */
public class AccountingBalance {
    public List<String> transfer(Map<String, Integer> balances) {
        PriorityQueue<String> minHeap = new PriorityQueue<>((a,b) -> balances.get(a) - balances.get(b));
        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) -> balances.get(b) - balances.get(a));

        for(String name: balances.keySet()) {
            if(balances.get(name) > 100) {
                maxHeap.add(name);
            } else if(balances.get(name) < 100) {
                minHeap.add(name);
            }
        }

        List<String> result = new ArrayList<>();

        while(!minHeap.isEmpty()) {
            String min = minHeap.peek();
            String max = maxHeap.peek();

            int balance = balances.get(min);
            if(balance >= 100) {
                break;
            }

            int needs = 100 - balance;
            if(balances.get(max) - 100 >= needs) {
                balances.put(max, balances.get(max) - needs);
                balances.put(min, balances.get(min) + needs);
                result.add("Transfer from " + max + " to " + min +" amount： " + needs);
                minHeap.poll();
                if(balances.get(max) == 100) {
                    maxHeap.poll();
                }
            } else {
                int left = balances.get(max) - 100;
                result.add("Transfer from " + max + " to " + min +" amount： " + left);
                balances.put(max, balances.get(max) - left);
                balances.put(min, balances.get(min) + left);
                maxHeap.poll();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        AccountingBalance a = new AccountingBalance();
        Map<String, Integer> map = new HashMap<>();
        map.put("AU", 80);
        map.put("US", 140);
        map.put("MX", 110);
        map.put("SG", 120);
        map.put("FR", 70);
        System.out.println(a.transfer(map));
    }
}
