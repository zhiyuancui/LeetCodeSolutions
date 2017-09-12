package solutions;

import java.util.HashMap;

public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		char [] arr1 = s.toCharArray();
        char [] arr2 = t.toCharArray();
        if(arr1.length != arr2.length){
            return false;
        }
        int[] record = new int['z'+1];
        for(int i =0; i< arr1.length; i++){
            record[arr1[i]]++;
        }

        for(int j = 0; j< arr2.length; j++){
            record[arr2[j]]--;
        }

        for(int a : record){
            if(a!=0){
                return false;
            }
        }
        return true;
        
    }
	
}
