package solutions.amazon.oa.Sep;

import java.util.Random;

public class CarWheel {

    public int total(int amount, int[] wheels) {
        if(amount <= 0 || amount % 2 == 1) {
            return 0;
        }

        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for(int wheel : wheels) {
            for(int i = wheel; i <= amount; i++) {
                dp[i] += dp[i- wheel];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        CarWheel c = new CarWheel();

        c.total(17, new int[]{2,4});
        Random r = new Random();
        int count = 0;
        while(count < 10000000) {
            int target = r.nextInt(100000);
            int actual = target % 2 == 0 && target > 0? target/ 4 + 1 : 0;
            int expect = c.total(target, new int[]{2,4});
            if(actual != expect) {
                System.out.println("Actual: " + actual + " Expected: " + expect+ " when " + target);
            }
            count++;
        }
    }
}
