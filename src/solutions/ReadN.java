package solutions;


/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * Reference to 
 * 
 * @author Zhiyuan
 *
 */
public class ReadN {
	private int buffPtr = 0;
    private int buffCount = 0;
    private char[] buff = new char[4];
    
    public int read(char[] buf, int n) {
        int ptr = 0;
        while( ptr < n ){
            if( buffPtr == 0 ){
                buffCount = read4( buff );
            }
            
            if( buffCount == 0 ){
                break;
            }
            
            while( ptr < n && buffPtr < buffCount ){
                buf[ ptr ] = buff[ buffPtr ];
                ptr++;
                buffPtr++;
            }
            
            if( buffPtr >= buffCount ){
                buffPtr = 0;
            }
            
        }
        
        return ptr;
    }
    
    private int read4(char[] buff){
    	return 1;
    }
}
