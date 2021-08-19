package solutions;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1439 Find the Kth Smallest Sum of a Matrix With Sorted Rows
 */
public class KthSmallestSumOfMatrix {
    public int kthSmallest(int[][] mat, int k) {

        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b-a);

        maxHeap.offer(0);

        for(int[] row: mat) {
            Queue<Integer> curHeap = new PriorityQueue<>((a,b) -> b-a);

            for(int preSum: maxHeap) {
                for(int i = 0;i < Math.min(row.length, k); i++) {
                    curHeap.offer(preSum + row[i]);
                    if(curHeap.size() > k) {
                        curHeap.poll();
                    }
                }
            }
            maxHeap = curHeap;
        }


        return maxHeap.poll();
    }

    int count = 0;
    public int kthSmallest2(int[][] mat, int k) {
        if(mat == null || mat.length == 0) {
            return 0;
        }

        int row = mat.length;
        int col = mat[0].length;

        int left = 0;
        int right = 0;

        for(int i = 0; i < row; i++) {
            left += mat[i][0];
            right += mat[i][col-1];
        }

        int init = left;
        while(left < right) {
            int mid = left + (right - left) / 2;

            count = 1;
            dfs(mid, 0, init, k, mat);
            if(count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private void dfs(int mid, int start, int sum, int k, int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        if(sum > mid || start == row || count > k) {
            return;
        }

        dfs(mid, start+1, sum, k, mat);

        for(int i = 1; i < col; i++) {
            if(sum + mat[start][i] - mat[start][0] <= mid) {
                count++;
                dfs(mid, start+1, sum+mat[start][i]-mat[start][0], k, mat);
            } else {
                break;
            }
        }
    }
}
