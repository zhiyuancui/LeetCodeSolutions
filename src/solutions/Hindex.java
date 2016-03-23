package solutions;

import java.util.Arrays;

public class Hindex {
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
	
	/**
	 * H-Index not sorted
	 * @param citations
	 * @return
	 */
	public int hIndex2(int[] citations) {
        if(citations==null || citations.length==0 )
        return 0;

    //if array has 1 element greater than 0, return 1    
    if(citations.length==1 && citations[0]>=1)
        return 1;

    //sort the array
    Arrays.sort(citations);

    //variable to keep track of length of array, hIndex
    int length=citations.length;
    int hIndex=0;

    //for loop to traverse the array
    for(int i=length-1;i>=0;i--)
    {
        //if value is present in array
        if(length-i==citations[i])
        {
            hIndex=citations[i];
        }
        else
        {
            //if value is not present in array
            if(i>0 &&citations[i-1]<=length-i && citations[i]>=length-i)
                hIndex=length-i;
        }


    }

    //first element is greater than 0, and hash index is 0, return the length of the array as answer
    if(citations.length>1 && citations[0]>citations.length && hIndex==0)
        hIndex=citations.length;


    //return the answer
    return hIndex;
    }
}
