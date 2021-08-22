package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 349 Intersection of Two Array
 */
public class IntersectionOfTwoArray {
	public int[] intersection(int[] nums1, int[] nums2) {
	  
	  Set<Integer> set = new HashSet<Integer>();
	  Set<Integer> intersect = new HashSet<Integer>();
	  
	  for(int i = 0; i < nums1.length; i++){
	      set.add(nums1[i]);
	  }
	  
	  for(int i = 0; i < nums2.length; i++){
	      if( set.contains(nums2[i]) ) {
	          intersect.add( nums2[i]);
	      }
	  }
	  
	  int[] result = new int[ intersect.size()];
	  int i = 0;
	  for(int num : intersect){
	      result[i++] = num;
	  }
	    
	    return result;
	}
}
