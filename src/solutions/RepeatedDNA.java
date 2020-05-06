package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNA {
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> hash = new HashSet<Integer>();
        HashSet<String> dna = new HashSet<String>();
        
        for(int i = 9; i < s.length(); i++){
            String substring = s.substring(i-9,i+1);
            int encoded = encode( substring );
            if( hash.contains( encoded ) ){
                dna.add( substring );
            }else{
                hash.add( encoded );
            }
        }
        
        List<String> result = new ArrayList<String>();
        for(String d : dna ){
            result.add(d);
        }
        
        return result;
    }

    private int encode(String s) {
        int sum =0;
        for(char c : s.toCharArray()) {
            if(c=='A') {
                sum = sum * 4;
            } else if( c == 'C') {
                sum = sum*4 + 1;
            } else if( c == 'G') {
                sum = sum *4 + 2;
            } else {
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
    
    
}
