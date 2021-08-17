package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Substring With Concatenation of All Words
 * @return
 */
public class FindSubstring {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new LinkedList<>();
		
        if (words.length == 0 || s.length() < words.length * words[0].length()){
        	return res;
        }
        
        
        int strLen = s.length();
        int wordNum = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer>curMap = new HashMap<>();
        
        for (String word : words) {
            if (map.containsKey(word)){
            	map.put(word, map.get(word) + 1);
            }
            else{
            	map.put(word, 1);
            }
        }
        
        String str = null, temp = null;
        
        for (int i = 0; i < wordLen; i++) {
            int count = 0;  // remark: reset count 
            for (int left = i, right = i; right + wordLen <= strLen; right += wordLen) {
                str = s.substring(right, right + wordLen);
                if (map.containsKey(str)) {
                    if (curMap.containsKey(str)){
                    	curMap.put(str, curMap.get(str) + 1);
                    }
                    else{
                    	curMap.put(str, 1);
                    }

                    if (curMap.get(str) <= map.get(str)){
                    	count++;
                    }
                    while (curMap.get(str) > map.get(str)) {
                        temp = s.substring(left, left + wordLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        left += wordLen;
                        if (curMap.get(temp) < map.get(temp)){
                        	count--;
                        }
                    }
                    if (count == wordNum) {
                        res.add(left);
                        temp = s.substring(left, left + wordLen);
                        curMap.put(temp, curMap.get(temp) - 1);
                        left += wordLen;
                        count--;
                    }
                }else {
                    curMap.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
            curMap.clear();
        }
        return res;
    }
}
