package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 42 Trapping Rain Water
 */
public class TrappingRainWater {

	public int trap(int[] height) {
        
        if( height == null || height.length == 0 )
        {
            return 0;
        }
        
        //Find max
        int max = 0;
        for( int i = 1; i < height.length; i++ )
        {
            if(height[i] > height[max])
            {
                max = i;
            }
        }
        
        //from left to max
        int water = 0;
        int top = 0;
        for(int i = 0; i < max; i++)
        {
            if( height[i] > top )
            {
                top = height[i];
            }
            else
            {
                water += top - height[i];
            }
        }
        
        //from right to max
        top = 0;
        for(int i = height.length - 1; i > max; i--)
        {
            if( height[i] > top )
            {
                top = height[i];
            }
            else
            {
                water += top - height[i];
            }
        }
        
        return water;
    }

	public int trapII(int[] height) {
		int ans = 0;

		Stack<Integer> stack = new Stack<>();
		int cur = 0;
		for(; cur < height.length; cur++) {
			while(!stack.isEmpty() && height[cur] > height[stack.peek()]) {
				int top = stack.pop();
				if(stack.isEmpty()) {
					break;
				}

				int w = cur - stack.peek() - 1;
				int h = Math.min(height[cur], height[stack.peek()]) - height[top];

				ans += w * h;
			}

			stack.push(cur);
		}

		return ans;
	}


}
