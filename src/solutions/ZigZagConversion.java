package solutions;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if( s== null || s.length() == 0 ){
            return "";
        }
        
        if( s.length() < numRows ){
            return s;
        }
        
        int len = s.length();
        
        char[] token = new char[len];
        
        int index = 0;
        for(int i = 0; i < numRows; i++ ){
            if( i == 0 ){
                for(int j = 0; i + j < len; j+=numRows+2 ){
                    token[index] = s.charAt( i + j );
                    index++;
                }
            }else if( i < numRows - 1 ){
                for(int j = 0; i + j  < len; j+=numRows-1 ){
                    token[index] = s.charAt( i + j );
                    index++;
                }
            }else{
                for(int j = 0; i + j  < len; j+=numRows+2 ){
                    token[index] = s.charAt( i + j );
                    index++;
                }
            }
            
        }
        
        return new String( token );
    }
	
	public static void main(String[] args){
		ZigZagConversion z = new ZigZagConversion();
		System.out.println( z.convert("PAYPALISHIRING", 6) ) ;
	}
}
