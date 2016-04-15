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
    
    public int encode(String s){
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            if( s.charAt(i) == 'A'){
                 sum = sum * 4;
            }else if( s.charAt(i) == 'C' ){
                sum = sum*4 + 1;
            }else if( s.charAt(i) == 'G' ){
                sum = sum * 4 + 2;
            }else{
                sum = sum * 4 + 3;
            }
        }
        return sum;
    }
    
    public static void main(String[] args){
    	RepeatedDNA r = new RepeatedDNA();
    	r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    }
}
