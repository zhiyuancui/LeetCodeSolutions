package solutions;

/**
 * http://www.hawstein.com/posts/binary-indexed-trees.html
 * Reference to : http://bookshadow.com/weblog/2015/11/18/leetcode-range-sum-query-mutable/
 * http://blog.csdn.net/int64ago/article/details/7429868
 * @author Zhiyuan
 *
 */
public class NumArray2 {
	int[] nums;
    int[] BIT;
    int n;

    public NumArray2(int[] nums) {
        this.nums = nums;

        n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++)
            init(i, nums[i]);
    }

    public void init(int i, int val) {
        i++;
        while (i <= n) {
            BIT[i] += val;
            i += (i & -i);
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        init(i, diff);
    }

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }
    
    public static void main(String[] args){
    	int[] nums = {1,3,5};
    	NumArray2 n = new NumArray2( nums );
    	n.sumRange(0, 2);
    }
}
