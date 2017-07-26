package solutions;


/**
 * Reference to: https://discuss.leetcode.com/topic/50586/math-solusion-based-on-euler-s-theorem-power-called-only-once-c-java-1-line-python/2 
 * @author Zhiyuan
 *
 */
public class SuperPow {
	
	public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int p = 0;
        for (int i : b){
        		p = (p * 10 + i) % 1140;
        }
        if (p == 0) {
        	p += 1440;
        }
        return power(a, p, 1337);
    }
    
    public int power(int a, int n, int mod) {
        a %= mod;
        int result = 1;
        while (n != 0) {
            if ((n & 1) != 0) {
            	result = result * a % mod;
            }
            a = a * a % mod;
            n >>= 1;
        }
        return result;
    }
    
    public int superPow2(int a, int[] b) {
    		int ans = 1;
    		int mod = 1337;
    		
    		for(int i = 0; i < b.length; i++) {
    			ans = pow(ans, 10, mod) * pow(a,b[i],mod) % mod;
    		}
    		
    		return ans;
    }
    
    private int pow(int a, int b, int mod) {
    		int res = 1;
    		int x = a % mod;
    		while( b != 0 ) {
    			if( (b&1)  == 1 ) {
    				res = res * x % mod;
    			}
    			
    			 x= x * x % mod;
    			 
    			 b >>=1;
    		}
    		return res;
    }
}
