package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabels {
	public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        
        int[] table = new int[26];
        char[] stc = S.toCharArray();
        for(char c:stc)//count the occurence of each char in string
            table[c-'a']++;
        
        int left = 0, right = 0, len = S.length(), counter = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < len){
            char c = stc[right];
            if(!set.contains(c)){// found new char in current window, so increase counter
                set.add(c);
                counter++;
            }
            table[c-'a']--;
            right++;
            if(table[c-'a'] == 0){ // decrease the counter as we have exhausted the c char and remove char c from set
                counter--;
                set.remove(c);
            }
            if(counter == 0){//if counter becomes 0, means current window is a partition
                res.add(right - left);//add length of current window
                left = right;// reset i for next window
            }            
        } 
        return res;
    }
}
