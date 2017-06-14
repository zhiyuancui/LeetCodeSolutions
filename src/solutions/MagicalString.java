package solutions;

public class MagicalString {

	/**
	 * Reference to: https://discuss.leetcode.com/topic/74917/simple-java-solution-using-one-array-and-two-pointers
	 * @param n
	 * @return
	 */
	public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        
        int[] a = new int[n + 1];
        a[0] = 1; a[1] = 2; a[2] = 2;
        int head = 2, tail = 3, num = 1, result = 1;
        
        while (tail < n) {
            for (int i = 0; i < a[head]; i++) {
                a[tail] = num;
                if (num == 1 && tail < n) result++;
                tail++;
            }
            num = num ^ 3;
            head++;
        }
        
        return result;
    }
}
