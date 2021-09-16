package solutions;

/**
 * 1052 Grumpy Bookstore Owner
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/solution/yong-mi-mi-ji-qiao-wan-liu-zhu-zui-duo-d-py41/
 */
public class GrumpyBookstore {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        int right = 0;

        int sumCalm = 0, sumSatisfied = 0;

        for(right = 0; right < x; right++) {
            if(grumpy[right] == 1) {
                sumCalm += customers[right];
            } else {
                sumSatisfied += customers[right];
            }
        }

        int maxCalm = sumCalm;

        for(int index = x; index < customers.length; index++) {
            if(grumpy[index-x] == 1) {
                sumCalm -= customers[index-x];
            }

            if(grumpy[index] == 0) {
                sumSatisfied += customers[index];
            } else {
                sumCalm += customers[index];
            }

            maxCalm = Math.max(sumCalm, maxCalm);
        }

        return sumSatisfied + maxCalm;
    }
}
