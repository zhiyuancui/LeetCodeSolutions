package solutions;

import java.util.PriorityQueue;

public class UglyNumber {
	
	public boolean isUgly(int num) {
        
        if( num <= 0 )
        {
            return false;
        }
        
        if( num == 1)
        {
            return true;
        }
        
        if( num % 2 == 0 )
        {
            return isUgly( num / 2 );
        }
        else if( num % 3 == 0 )
        {
            return isUgly( num / 3 );
        }
        else if( num % 5 == 0 )
        {
            return isUgly( num / 5);
        }
        else
        {
            return false;
        }
    }
	
	/**
	 * Ugly Number II
	 * @param n
	 * @return
	 */
	public int nthUglyNumber(int n) {
        if( n == 1 ){
            return 1;
        }
        
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 = 1,p3=1,p5=1;
        for(int i =2; i <=n; i++){
            dp[i] = Math.min(2*dp[p2], Math.min(3*dp[p3], 5*dp[p5]));
            if( dp[i] == 2*dp[p2] ){
                p2++;
            }
            if( dp[i] == 3*dp[p3] ){
                p3++;
            }
            if( dp[i] == 5*dp[p5] ){
                p5++;
            }
        }
        
        return dp[n];
    }
	
	/**
	 * Super Ugly Number
	 * Reference to https://www.hrwhisper.me/leetcode-super-ugly-number/
	 * @param n
	 * @param primes
	 * @return
	 */
	public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly_number = new int[n];
        ugly_number[0] = 1;
        PriorityQueue<Node> q = new PriorityQueue<Node>();
        for (int i = 0; i < primes.length; i++)
            q.add(new Node(0, primes[i], primes[i]));
        for (int i = 1; i < n; i++) {
            Node cur = q.peek();
            ugly_number[i] = cur.val;
            do {
                cur = q.poll();
                cur.val = ugly_number[++cur.index] * cur.prime;
                q.add(cur);
            } while (!q.isEmpty() && q.peek().val == ugly_number[i]);
        }
        return ugly_number[n - 1];
    }

 
	class Node implements Comparable<Node> {
	    int index;
	    int val;
	    int prime;
	 
	    Node(int index, int val, int prime) {
	        this.val = val;
	        this.index = index;
	        this.prime = prime;
	    }
	 
	    public int compareTo(Node x) {
	        return this.val - x.val ;
	    }
	}
}
