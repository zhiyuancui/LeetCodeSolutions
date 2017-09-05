package solutions;

import java.util.stream.Stream;

public class FractionAddition {
	public String fractionAddition(String expression) {
        String[] fracs = expression.split("(?=[-,+])");
        String res  = "0/1";
        for(String frac:fracs) {
            res = add( res, frac);
        }
        
        return res;
    }
    
    public String add(String frac1, String frac2 ){
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray();
        int[] f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        
        int numer = f1[0] * f2[1] + f2[0]*f1[1];
        int denom = f1[1] * f2[1];
        
        String sign = "";
        
        if(numer < 0){
            sign = "-";
            numer *= -1;
        }
        
        int common = gcd(numer, denom);
        
        return sign + (numer/ common ) + "/" + (denom/common);
        
    }
    
    private int gcd(int x, int y ){
        return x == 0 || y == 0 ? x+y : gcd(y,x%y);
    }
}
