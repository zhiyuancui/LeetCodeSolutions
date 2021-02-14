package solutions;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
		if(s == null || t == null) {
            return null;
        }
        
        int[] hashMap = new int[256];
        int len = t.length();
        for(char c : t.toCharArray()) {
            hashMap[c]++;
        }
        
        int right = 0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        int count = 0;
        
        while(right < s.length()) {
            if(hashMap[s.charAt(right)] > 0) {

                count++;
            }
            hashMap[s.charAt(right)]--;
            while(count >= len) {
                if(min > right - left +1) {
                    min = right - left + 1;
                    result = s.substring(left, right+1);
                }
                hashMap[s.charAt(left)]++;
                System.out.println(s.charAt(left)+":"+hashMap[s.charAt(left)]);
                if(hashMap[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
                
            }
            right++;
        }
        
        return result;
    }
    
    private int initTargetHash(int[] targethash, String Target ){
        int targetnum = 0;
        for( char ch : Target.toCharArray() ){
            targetnum++;
            targethash[ch]++;
        }
        
        return targetnum;
    }
    
    /**
     * https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems/2
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] targethash = new int[256];
        
        int targetnum = initTargetHash( targethash, t);
        
        int counter = t.length();
        int left = 0;
        int right = 0;
        
        int minLen = Integer.MAX_VALUE;
        int head = 0;
        
        while( right < s.length() ) {
            if( targethash[s.charAt(right)] > 0  ) {
                counter--;
            }
            targethash[ s.charAt(right) ]--;
            right++;
            while( counter == 0 ) {
                if( right - left < minLen ) {
                    minLen = right - left;
                    head = left;
                }
                targethash[ s.charAt(left) ]++;
                if( targethash[s.charAt(left)] > 0 ) {
                    counter++;
                }
                left++;
            }
        }   
            return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head+minLen); 
    }
    
 
}
