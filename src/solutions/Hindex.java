package solutions;

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
}
