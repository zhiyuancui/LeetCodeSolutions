package solutions;

public class Base7 {
	public String convertToBase7(int num) {
        boolean neg = false;
        
        if( num > -7 && num < 7 ) {
            return num+"";
        }
        
        if( num < 0 ){
            neg = true;
            num= -num;
        }
        
        StringBuilder sb = new StringBuilder();
        while( num > 0 ){
            sb.append( num % 7 );
            num = num / 7;
        }
        
        return neg? "-"+ sb.reverse() : sb.reverse().toString();
    }
}
