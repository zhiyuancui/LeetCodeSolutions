package solutions;

import java.util.Arrays;

public class Hindex {
	
	/**
	 * H-index II sorted
	 * @param citations
	 * @return
	 */
	public int hIndex(int[] citations) {
        if( citations == null || citations.length == 0 ){
            return 0;
        }
        
        int start = 0;
        int end = citations.length - 1;
        int len = citations.length;
        int hIndex = 0;
        
        while( start <= end ){
            
            int mid = start + ( end - start ) / 2;
            if( citations[ mid ] >= ( len - mid ) ){
                hIndex = ( len - mid );
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return hIndex;
    }
	
	public int hIndex3(int[] citations) {
        int len = citations.length;
        for(int i = 0; i < len; i++){
            if( citations[i] >= len - i ){
                return len - i;
            }
        }
        
        return 0;
    }
	
	/**
	 * H-Index not sorted.
	 * Method 1: sort the array first then the problem becomes H-index II
	 * Method 2: 
	 * @param citations
	 * @return
	 */
	public int hIndex2(int[] citations) {
        if(citations==null || citations.length==0 ){
        	return 0;
        }
        
        int len = citations.length;
        
        int[] count = new int[ len + 1 ];
        
        for(int val : citations){
        	if( val >= len ){
        		count[len]++;
        	}else{
        		count[ val ]++;
        	}
        }
   
        int hindex = 0;
        for(int i = len; i > 0; i--){
        	hindex += count[i];
        	if( hindex >= i ){
        		return i;
        	}
        }
        
        return 0;
    }
}
