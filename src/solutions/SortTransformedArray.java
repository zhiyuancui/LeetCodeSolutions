package solutions;

public class SortTransformedArray {

	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if( nums == null || nums.length == 0 ) {
            return new int[0];
        }
        
        int[] sorted = new int[ nums.length ];
        int index = a >=0 ? nums.length - 1 : 0 ;
        int left = 0;
        int right = nums.length - 1;
        
        while( left <=right ) {
            if( a >=0 ) {
                if( getValue( nums[left], a,b, c ) >= getValue( nums[right], a, b, c ) ) {
                    sorted[ index ] = getValue( nums[left], a, b, c );
                    left++;
                } else {
                    sorted[ index ] = getValue( nums[right], a, b, c );
                    right--;
                }
                index--;
            } else {
                if( getValue( nums[left], a,b, c ) >= getValue( nums[right], a, b, c ) ) {
                    sorted[ index ] = getValue( nums[right], a, b, c );
                    right--;
                } else {
                    sorted[ index ] = getValue( nums[left], a, b, c );
                    left++;
                }
                index++;
            }
        }
        
        return sorted;
    }
    
    private int getValue( int x, int a, int b, int c ){
        return a*x*x + b*x + c;
    }
}
