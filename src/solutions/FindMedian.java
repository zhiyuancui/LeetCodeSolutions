package solutions;


/***
 * Reference to : https://leetcode.com/discuss/74981/java-easy-version-to-understand
 * 
 * @author Zhiyuan
 *
 */
public class FindMedian {
	private int findKthSmallest(int[] num1, int len1, int begin1, int[] num2, int len2, int begin2, int k) {

	    if (len1 > len2)
	        return findKthSmallest(num2, len2, begin2, num1, len1, begin1, k);
	    if (len1 == 0)
	        return num2[begin2 + k - 1];
	    if (k == 1)
	        return Integer.min(num1[begin1], num2[begin2]);
	    int partA = Integer.min(k / 2, len1);
	    int partB = k - partA;
	    if (num1[begin1 + partA - 1] == num2[begin2 + partB - 1]){
	    	return num1[begin1 + partA - 1];
	    }
	    else if (num1[begin1 + partA - 1] > num2[begin2 + partB - 1]){
	    	return findKthSmallest(num1, len1, begin1, num2, len2 - partB, begin2 + partB, k - partB);
	    }
	    else{
	        return findKthSmallest(num1, len1 - partA, begin1 + partA, num2, len2, begin2, k - partA);
	    }
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int len1 = nums1.length, len2 = nums2.length, sumLen = len1 + len2;
	    if (sumLen % 2 != 0) {

	        return findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1);
	    } else {
	        return (findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2)
	                + findKthSmallest(nums1, len1, 0, nums2, len2, 0, sumLen / 2 + 1)) / 2.0;
	    }

	}
	
	public static void main(String[] args){
		FindMedian f = new FindMedian();
		int[] nums1 = {1,3,5,7,9};
		int[] nums2 = {2,4,6,8,10};
		f.findMedianSortedArrays(nums1, nums2);
	}
}
