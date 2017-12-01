package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {


public List<List<String>> groupAnagrams(String[] strs) {
               
        List<List<String>> result = new ArrayList<List<String>>();
        
        if( strs == null || strs.length == 0 )
        {
            return result;
        }
        
        HashMap<String, List<String> > map = new HashMap<String, List<String> >();
        
        for( String s : strs )
        {
            s = s.toLowerCase();
             
            String code = code(s);
            if( map.containsKey( code ) )
            {
                List<String> group = map.get(code);
                group.add(s);
                map.put( code, group );
            }
            else
            {
                List<String> group = new ArrayList<String>();
                group.add(s);
                map.put( code, group);
            }
        }
        
        
        
        for( List<String> group : map.values() )
        {
            Collections.sort( group );
            result.add( group );
        }
        
        return result;
        
    }
    
    private String code(String s)
    {
        char[] temp = s.toCharArray();
        
        Arrays.sort( temp );
        
        return new String( temp );
    }
    
}
