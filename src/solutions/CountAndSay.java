package solutions;

public class CountAndSay {

public String countAndSay(int n) {
        
	if( n < 1 ) {
        return "";
    }
    

    
    int time = 1;
    String result = "1";
    
    while( time < n ) {
        StringBuilder next = new StringBuilder();
        int count = 0;
        char token = 'a';
        for(int i = 0; i < result.length(); i++ ) {
            
            if( token != result.charAt(i) ) {
                if( count != 0 ){
                    next.append(count).append(token);
                }
                count = 1;
                token = result.charAt(i);
            } else {
                count++;
            }
        }
        
        next.append(count).append(token);
        result = next.toString();
        time++;
    }
    
    return result;
}

}
