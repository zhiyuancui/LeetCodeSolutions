package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 71 Simplify Path
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
        if( path == null || path.length() == 0 ){
            return "";
        }
        
        List<String> paths = new ArrayList<String>();
        
        String[] parts = path.split("/");
        
        if( parts.length == 0 ){
            return "/";
        }
        
        for(String token : parts){
            switch( token ){
                case ".":
                    break;
                case "..":
                    if( paths.size() > 0 ){
                        paths.remove(paths.size() - 1 );
                    }
                    break;
                default:
                	if( token.length() == 0 ){
                		break;
                	}
                    paths.add(token);
            }
        }
        
        String result = "";
        for(String token : paths ){
            result +="/" + token;
        }
        
        return result.length() == 0 ? "/" : result;
        
    }
}
