package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
	      List<List<String>> result = new ArrayList<>();
	        if(accounts==null || accounts.size()==0)
	            return result;
	        
	        Map<String, String> names = new HashMap<String, String>(); //email - username
	        Map<String, Set<String>> map = new HashMap<String, Set<String>>(); //email - neighbors
	        Set<String> emails = new HashSet<String>(); 
	        
	        for(List<String> list : accounts){
	            String name = list.get(0);
	            for(int i=1; i<list.size(); i++){
	                String email = list.get(i);
	                emails.add( email ); 
	                names.put( email, name );
	                map.putIfAbsent( email, new HashSet<String>() );
	                
	                if(i==1)
	                    continue;
	                
	                //build the "edge" between two adjacent email-nodes
	                map.get( list.get(i-1) ).add( email );
	                map.get( email ).add( list.get(i-1) );
	            }
	        }
	        
	        Set<String> visited = new HashSet<String>();
	        for(String email : emails)
	            if( !visited.contains(email) ){
	                visited.add(email);
	                List<String> buffer = new ArrayList<String>();
	                buffer.add(email);
	                helper(email, map, visited, buffer);
	                Collections.sort(buffer);
	                buffer.add(0, names.get(email));
	                result.add(buffer);
	            }
	        return result; 
	    }
	    
	    private void helper(String s, Map<String, Set<String>> map, Set<String> visited, List<String> buffer){
	        for(String node : map.get(s))
	            if( !visited.contains(node) ){
	                visited.add(node);
	                buffer.add(node);
	                helper(node, map, visited, buffer);
	            }
	    }
}
