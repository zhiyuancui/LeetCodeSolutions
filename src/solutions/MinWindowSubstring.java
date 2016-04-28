package solutions;

public class MinWindowSubstring {
	public String minWindow(String s, String t) {
        int ans = Integer.MAX_VALUE;
        String minStr = "";
        
        int[] targethash = new int[256];
        
        int targetnum = initTargetHash( targethash, t);
        
        int sourcenum = 0;
        int left = 0, right = 0;
        
        for( right = 0; right<s.length(); right++){
            if( targethash[ s.charAt(right) ] > 0 ){
                sourcenum++;
            }
            
            targethash[s.charAt(right)]--;
            while( sourcenum >= targetnum ){
                if( ans > right - left + 1 ){
                    ans = Math.min(ans, right - left + 1);
                    minStr = s.substring(left, right + 1 );
                }
                
                targethash[ s.charAt(left) ]++;
                if( targethash[ s.charAt( left) ] > 0 ){
                    sourcenum--;
                }
                left++;
            }
        }
        return minStr;    
    }
    
    private int initTargetHash(int[] targethash, String Target ){
        int targetnum = 0;
        for( char ch : Target.toCharArray() ){
            targetnum++;
            targethash[ch]++;
        }
        
        return targetnum;
    }
    
    public static void main(String[] args){
    	System.out.println(Integer.MIN_VALUE);
    }
}
