/**
 * Container with Most Water
 */
package solutions;

public class MaxArea {

	public int maxArea(int[] height) {
        
        if( height == null || height.length == 0 )
        {
            return 0;
        }
        
        int left = 0;
        int right = height.length - 1;
        int max = -1;
        
        while( left < right )
        {
            int minHeight = height[left] > height[right] ? height[right] : height[left];
            max = Math.max( max, minHeight * (right - left) );
            
            if(height[left] > height[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        
        return max;
    }
}
