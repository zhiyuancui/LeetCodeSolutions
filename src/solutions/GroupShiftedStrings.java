package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
        if( strings == null || strings.length == 0 ) {
            return new ArrayList<>();
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for( String str : strings ) {
            String code = encode(str);
            if( !map.containsKey(code) ) {
                map.put( code, new ArrayList<>() );
            }
            map.get(code).add(str);
        }
        
        List<List<String>> result = new ArrayList<>();
        for( String key : map.keySet() ) {
             List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    private String encode( String s ) {
        int shift = s.charAt(0) - 'a';
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++ ) {
            char c = (char)(s.charAt(i) - shift);
            if( c < 'a' ) {
                c += 26;
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}
