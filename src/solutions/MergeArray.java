/**
 * Merge sorted array
 */
package solutions;

public class MergeArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index = m + n - 1;
        
        int index1 = m - 1;
        int index2 = n - 1;
        
        while( index1 >= 0 && index2 >= 0 )
        {
            int val1 = nums1[ index1 ]; 
            int val2 = nums2[ index2 ];
            
            if( val1 > val2 )
            {
                nums1[ index-- ] = val1;
                index1--;
            }
            else
            {
                nums1[ index-- ] = val2;
                index2--;
            }

        }
        
        while( index1 >= 0 )
        {
            nums1[ index-- ] = nums1[index1];
            index1--;
        }
        
        while( index2 >= 0 )
        {
            nums1[ index-- ] = nums2[index2];
            index2--;
        }
    }
}
