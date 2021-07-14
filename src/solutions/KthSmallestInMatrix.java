package solutions;

/**
 * 378 Kth Smallest Element in a Sorted Matrix
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/solution/er-fen-chao-ji-jian-dan-by-jacksu1024/
 */
public class KthSmallestInMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = matrix[0][0];
        int right = matrix[row-1][col-1];

        while(left < right) {
            int mid = left + (right - left) / 2;

            int count = helper(matrix, mid);

            if(count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private int helper(int[][] matrix, int mid) {
        int row = matrix.length;
        int col = matrix[0].length;

        int i = row - 1;
        int j = 0;

        int count = 0;

        //按列查找
        while(i >= 0 && j < col) {
            if(matrix[i][j] > mid) {
                i--;
            } else {
                //你现在只能确定这一列，前几个元素比mid小
                count += i + 1;
                j++;
            }
        }

        return count;
    }
}
