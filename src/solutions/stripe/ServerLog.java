package solutions.stripe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

    public int getBestRemovalTime(List<Integer> logs) {
        int[] arr = logs.stream().mapToInt(i -> i).toArray();
        return getBestRemovalTime(arr);
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

   // https://www.1point3acres.com/bbs/thread-791237-1-1.html
   private List<Integer> getBestRemovalTimeFromfile(String filePath) throws Exception {
       if(filePath == null || filePath.length() == 0) {
           throw new IllegalArgumentException();
       }

       List<Integer> logs = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

       boolean hasBegin = false;

       try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
           String line;
           while ((line = br.readLine()) != null) {
               String[] tokens = line.split("\\s+");
               for(String token : tokens) {
                   if(token.equals("BEGIN")) {
                       hasBegin = true;
                       logs = new ArrayList<>();
                   } else if(hasBegin && isNumber(token)) {
                       logs.add(Integer.parseInt(token));
                   } else if(hasBegin && token.equals("END")) {
                       result.add(getBestRemovalTime(logs));
                       hasBegin = false;
                   } else {
                       logs = new ArrayList<>();
                   }
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
           System.out.println(s.getBestRemovalTime("BEGIN BEGIN 1 0 0 END 0 0 0 1 BEGIN 1 1 1 0 END"));
           System.out.println(s.getBestRemovalTimeFromfile("src/solutions/stripe/test.txt"));
       } catch(Exception e) {
           e.printStackTrace();
       }
   }
}
