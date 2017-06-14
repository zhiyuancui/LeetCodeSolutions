package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArray {

	/**
	 * Intersection of Two Array 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
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
	
	/**
	 * Intersection of Two Array II
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < nums1.length; i++) {
            int count = map.getOrDefault(nums1[i],0) + 1;
            map.put(nums1[i], count);
        }
        
        for(int i = 0; i < nums2.length; i++) {
            if( map.containsKey( nums2[i]) && map.get(nums2[i]) > 0 ) {
                result.add( nums2[i] );
                map.put( nums2[i], map.get(nums2[i]) - 1);
            }
        }
        
        int[] r = new int[result.size()];
        for(int i =0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        
        return r;
    }
}
