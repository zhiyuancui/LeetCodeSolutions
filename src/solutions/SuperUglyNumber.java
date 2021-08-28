package solutions;

import java.util.PriorityQueue;

/**
 * 313 Super Ugly Number
 */
public class SuperUglyNumber {
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
            return this.val - x.val;
        }
    }

    /**
     * https://leetcode-cn.com/problems/super-ugly-number/solution/dong-tai-gui-hua-java-by-liweiwei1419-1yna/
     * @param n
     * @param primes
     * @return
     */
    public int nthSuperUglyNumber2(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            int currUglyNumber = Integer.MAX_VALUE;

            for (int j = 0; j < primes.length; j++) {
                currUglyNumber = Math.min (currUglyNumber, dp[count[j]] * primes[j]);
            }

            for (int j = 0; j < count.length; j++) {
                if (currUglyNumber == dp[count[j]] * primes[j]) {
                    count[j]++;
                }
            }

            dp[i] = currUglyNumber;
        }

        return dp[n - 1];
    }
}
