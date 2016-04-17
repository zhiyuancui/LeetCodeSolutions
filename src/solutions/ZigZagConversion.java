package solutions;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if( numRows <= 1 ){
            return s;
        }
        
        StringBuilder[] sb = new StringBuilder[ numRows ];
        
        for( int i = 0; i < sb.length; i++ ){
            sb[i] = new StringBuilder("");
        }
        
        int incre = 1;
        int index = 0;
        
        for(int i = 0; i < s.length(); i++ ){
            sb[ index ].append( s.charAt(i) );
            if( index == 0 ){
                incre = 1;
            }
            if( index == numRows - 1 ){
                incre = -1;
            }
            index += incre;
        }
        String result = "";
        for(int i = 0; i < sb.length; i++ ){
            result += sb[i];
        }
        
        return result;
    }
	
	public static void main(String[] args){
		ZigZagConversion z = new ZigZagConversion();
		System.out.println( z.convert("PAYPALISHIRING", 6) ) ;
	}
}
