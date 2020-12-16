package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> result = new ArrayList<>(); 
	    if (words == null || words.length < 2){
	      return result;  
	    } 
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i<words.length; i++){ 
	        map.put(words[i], i);
	    }
	    for (int i=0; i<words.length; i++) {
	        
	        for (int j=0; j<=words[i].length(); j++) { 
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            if (isPalindrome(str1)) {
	                String str2rvs = new StringBuilder(str2).reverse().toString();
	                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(map.get(str2rvs));
	                    list.add(i);
	                    result.add(list);
	                    
	                }
	            }
	            if (isPalindrome(str2)) {
	                String str1rvs = new StringBuilder(str1).reverse().toString();
	               
	                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
	                    List<Integer> list = new ArrayList<Integer>();
	                    list.add(i);
	                    list.add(map.get(str1rvs));
	                    result.add(list);
	                }
	            }
	        }
	    }
	    return result;
	}

	private boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    while (left <= right) {
	        if (str.charAt(left++) !=  str.charAt(right--)) return false;
	    }
	    return true;
	}
	
}
