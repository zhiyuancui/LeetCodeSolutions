package solutions;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
        
        int start = 0;
        int end = n;
        
        while( end - start > 1 ){
            int mid = start + ( end - start ) / 2;
            
            if( isBadVersion(mid) ){
                end = mid;
            }else{
                start = mid;
            }
        }
        
        return end;
    }
	
	private boolean isBadVersion(int n){
		return true;
	}
}
