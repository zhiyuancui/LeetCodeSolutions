package solutions;

/**
 * See discussion at: http://blog.csdn.net/swartz2015/article/details/50561199
 * @author Zhiyuan
 *
 */
public class BurstBalloons {
	public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        
        for(int i = 0; i < n - 2; i++){
            newNums[ i + 1 ] = nums[i];
        }
        
        newNums[0] = newNums[n-1] = 1;
        
        int[][] matrix = new int[n][n];
        
        for(int i = 2; i <n; i++){//the distance of left between right is i.
            for( int left = 0; i+left<n;left++ ){
                int right = i+left;
                for(int m = left+1; m<right;m++){
                    matrix[left][right] = Math.max(matrix[left][right], newNums[left]*newNums[m]*newNums[right] + matrix[left][m] + matrix[m][right]);
                }
            }
        }
        
        return matrix[0][n-1];
    }
}
