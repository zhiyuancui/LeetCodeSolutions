package solutions.stripe;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// https://www.1point3acres.com/bbs/thread-771600-1-1.html
public class ServerLog {

    //Question 1
   public int computePenalty(int[] log, int time) {

       int penalty = 0;
       for(int i = 0; i < log.length; i++) {
           if(i < time && log[i] == 1) {
               penalty++;
           } else if(i >= time && log[i] == 0) {
               penalty++;
           }
       }

       return penalty;
   }

   //Question 2
   // 要去clarify有没有4， 如果出现tie怎么办
   public int getBestRemovalTime(int[] log) {
       int cost = Integer.MAX_VALUE;
       int idx = 0;
       for(int i = 0; i <= log.length; i++) {
           int penalty = computePenalty(log, i);
           if(cost > penalty) {
               idx = i;
               cost = penalty;
           }
       }

       return idx;
   }

   //Question 3
   public List<Integer> getBestRemovalTime(String log) throws Exception{
       if(log == null || log.length() == 0) {
           throw  new IllegalArgumentException();
       }

       String[] tokens = log.split("\\s+");

       List<Integer> result = new ArrayList<>();

       for(int left = 0; left < tokens.length - 1; left++) {
            if(tokens[left].equals("BEGIN")) {
                int right = left + 1;
                while(isNumber(tokens[right])) {
                    right++;
                }
                if(tokens[right].equals("END")) {
                    int[] logs = new int[right - left - 1];
                    int idx = 0;
                    for(int i = left + 1; i < right; i++) {
                        logs[idx] = Integer.parseInt(tokens[i]);
                        idx++;
                    }

                    int bestTime = getBestRemovalTime(logs);
                    result.add(bestTime);
                    left = right;
                } else {
                    left = right - 1;
                }
            }
       }
       return result;
   }

   private boolean isNumber(String s) {
       if (s == null) {
           return false;
       }
       try {
           int i = Integer.parseInt(s);
       } catch (NumberFormatException nfe) {
           return false;
       }
       return true;
   }

   public static void main(String[] args) {
       ServerLog s = new ServerLog();
       try {
           System.out.println(s.computePenalty(new int[]{0, 0, 1, 0}, 0));
           System.out.println(s.getBestRemovalTime(new int[]{0, 0, 1, 0}));
           System.out.println(s.getBestRemovalTime("BEGIN BEGIN BEGIN 1 1 BEGIN 0 0 END 1 1 BEGIN"));
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
}
