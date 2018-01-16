package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {
public List<String> findItinerary(String[][] tickets) {
        
        Map<String, List<String>> ticketMap = new HashMap<String, List<String>>();
        
        for( String[] ticket : tickets ) {
            if( !ticketMap.containsKey( ticket[0] ) ) {
            	ticketMap.put( ticket[0], new ArrayList<>() );
            }
            List<String> list = ticketMap.get( ticket[0] );
            list.add( ticket[1] );
        }
        
        for( String key : ticketMap.keySet() ) {
            Collections.sort( ticketMap.get(key) );
        }
        
        List<String> path = new ArrayList<String>();
        helper("JFK",ticketMap, tickets.length + 1, path);
        return path;
        
    }
    
    private boolean helper(String src, Map<String, List<String>> ticketMap, int n, 
        List<String> currentPath){
        
        currentPath.add( src );
        if( currentPath.size() >= n ){
            return true;
        }  
        
        if( !ticketMap.containsKey( src ) || ticketMap.get( src ).isEmpty() ){
            return false;
        }
        
        List<String> destList = ticketMap.get( src );
        for(int i = 0; i < destList.size(); i++){
            String travel = destList.remove(i);
            
            if( helper( travel, ticketMap, n, currentPath) ){
                return true;
            }
            
            currentPath.remove( currentPath.size() - 1 );
            destList.add(i, travel);
        }
        
        return false;
    }
}
