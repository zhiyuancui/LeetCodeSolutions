package solutions;

public class CountStrSeg {
	public int countSegments(String s) {
        if( s == null || s.length() == 0 ) {
            return 0;
        }
        
        String[] parts = s.split("\\s+");
        int count = 0;
        
        for(String seg: parts){
            if( seg.length() > 0 ){
                count++;
            }
        }
        
        return count;
               
    }
}
