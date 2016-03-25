package solutions;

public class AdditiveNum {
	public boolean isAdditiveNumber(String num) {
        if( num == null || num.length() < 3 ){
            return false;
        }
        
        for(int i = 0; i < ( num.length() - 1 ) / 2; i++){
            for(int j = i+1; num.length() - j - 1 >= Math.max(i+1,j-i); j++){
                int offset = j + 1;
                String num1 = num.substring(0,i+1);
                String num2 = num.substring(i+1, j + 1);
                
                while( offset < num.length() ){
                    if( num1.charAt(0) == '0' && num1.length() > 1 ) break;
                    if( num2.charAt(0) == '0' && num2.length() > 1 ) break;
                    
                    String sum = String.valueOf(Long.parseLong(num1) + Long.parseLong(num2) );
                    if( !num.startsWith(sum, offset)) break;
                    
                    num1 = num2;
                    num2 = sum;
                    offset += sum.length();
                }
                if( offset == num.length() ) return true;
            }
        }
        
        return false;
    }
	
}
