package solutions;

public class ValidSquare {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		long[] lengths = { length(p1,p2), length(p2,p3),length(p3,p4),length(p4,p1),length(p1,p3),length(p2,p4)};
	    long max = 0, nonMax = 0;
	    for(long len: lengths) {
	        max = Math.max(max,len);
	    }
	    
	    int count = 0;
	    for(long len : lengths ){
	        if( len == max ) {
	            count++;
	        } else {
	            nonMax = len;
	        }
	    }
	    
	    if( count != 2 ) return false;
	    
	    for(long len: lengths) {
	        if( len != max && len != nonMax) return false;
	    }
	    
	    return true;
	}

	private long length(int[] p1, int[] p2){
	    return (long)Math.pow(p1[0]-p2[0],2) + (long)Math.pow(p1[1] - p2[1],2);  
	}
}
