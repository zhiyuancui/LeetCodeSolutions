package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRestaurant {
	public String[] findRestaurant(String[] list1, String[] list2) {
        
        List<String> res = new ArrayList<String>();
        int min = Integer.MAX_VALUE;
        Map<String, Integer> restaurant = new HashMap<String, Integer>();
        
        for(int i =0; i < list1.length; i++) {
            restaurant.put( list1[i],i);
        }
        
        for(int i =0; i < list2.length; i++) {
            if( restaurant.containsKey(list2[i]) ) {
                int index = i + restaurant.get( list2[i] );
                if( index == min ){
                    res.add( list2[i]);
                }
                if( index < min ){
                    min = index;
                    res = new ArrayList<String>();
                    res.add( list2[i]);
                }
            }
        }
        String[] result = new String[res.size()];
        int i =0;
        for(String s : res){
            result[i] = s;
            i++;
        }
        return result;
        
    }
}
