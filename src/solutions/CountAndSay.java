package solutions;

public class CountAndSay {

public String countAndSay(int n) {
        
        if( n < 1 )
        {
            return "";
        }
        
        int times = 1;
        
        String result = "1";
        while( times < n )
        {
            String old = result;
            int count = 0;
            char token = old.charAt(0);
            String next = "";
            for(int i = 0; i < old.length(); i++)
            {
                if( i == 0 )
                {
                    token = old.charAt(0);
                    count++;
                    continue;
                }
                
                if( token == old.charAt(i) )
                {
                    count++;
                }
                else
                {
                    next += Integer.toString(count) + Character.toString( token );
                    count=1;
                    token = old.charAt(i);
                }
            }
            
            next += Integer.toString(count) + Character.toString( token );
            
            result = next;
            times++;
        }
        
        return result;
    }


	public static void main(String[] args )
	{
		CountAndSay c = new CountAndSay();
		c.countAndSay(3);
	}
}
