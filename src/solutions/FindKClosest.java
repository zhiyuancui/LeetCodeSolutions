package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosest {
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
        arr = arr.subList(0, k);
        Collections.sort(arr);
        return arr;
   }
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-k;
        
        while(start<end) {
            int mid = (start + end)/2;
            if (x - arr[mid] > arr[mid+k]-x)
                start = mid + 1;
            else
                end = mid;
        }

        List<Integer> results = new ArrayList<Integer>();
        for(int i=start;i<start+k;i++){
            results.add(arr[i]);
        }
        return results;
    }
}
