package solutions;

import java.util.Stack;

public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        if( matrix == null || matrix.length == 0 ) {
            return 0;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[] heights = new int[ col ];
        for(int i = 0; i < col; i++ ) {
            heights[i] = matrix[0][i] - '0';
        }
        
        int result = maxRectangle(heights);
        
        for(int i = 1; i < row; i++ ) {
            resetHeight(heights, matrix, i );
            result = Math.max(result, maxRectangle(heights) );
        }
        
        return result;
    }
    
    private void resetHeight(int[] heights, char[][] matrix, int row ) {
        for(int i = 0; i < matrix[0].length; i++ ) {
            if( matrix[row][i] == '0' ) {
                heights[i] = 0;
            } else {
                heights[i]++;
            }
        }
    }
    
    private int maxRectangle(int[] heights ) {
        Stack<Integer> stack = new Stack<>();
        
        int max = 0;
        for(int i = 0; i <= heights.length; i++ ) {
            int cur = i < heights.length ? heights[i] : 0;
            while(!stack.isEmpty() && cur < heights[ stack.peek() ] ) {
                int h = heights[ stack.pop() ];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
            stack.push(i);
        }
        
        return max;
    }
}
