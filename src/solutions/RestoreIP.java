package solutions;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if( s == null || s.length() == 0 || s.length() < 4 || s.length() > 12){
            return result;
        }
        
        List<String> IP = new ArrayList<String>();
        generate(result, IP,0, s );
        return result;
    }
    
    private void generate(List<String> result, List<String> IP, int start, String s){
        if( IP.size() == 4 ){
            if( start != s.length() ){
                return;
            }
            StringBuilder ip = new StringBuilder();
            for(String number : IP ){
                ip.append(number+".");
            }
            ip.deleteCharAt(ip.length() - 1 );
            result.add(ip.toString());
            return;
        }
        
        for(int i = start; i < s.length() && i < start + 3 ; i++){
            String part = s.substring(start, i + 1);
            if( validIP( part ) ){
                IP.add( part );
                generate(result, IP, i + 1, s );
                IP.remove(IP.size() - 1);
            }
        }
    }
    
    private boolean validIP(String s){
        if( s.charAt(0) == '0' ){
            return s.equals("0");
        }
        
        int digit = Integer.parseInt( s );
        return digit >=0 && digit <= 255;
    }
}
