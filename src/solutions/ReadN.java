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
    private final char[] buff = new char[4];
    
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
    
    /**
     *  Read N Characters Given Read4 II - Call multiple times
     * @param buf
     * @param n
     * @return
     */
    char[] cache = new char[4];
    int cachePtr  = 0;
    int cacheCount = 0;
    int ptr = 0;
    public int read2(char[] buf, int n) {
        ptr=0;
        while( ptr < n ) {
            if( cachePtr == 0 ) {
                cacheCount = read4( cache );
            }
            
            if( cacheCount == 0 ) {
                break;
            }
            
            while( ptr < n && cachePtr < cacheCount ) {
                buf[ ptr ] = cache[ cachePtr ];
                ptr++;
                cachePtr++;
            }
            if( cachePtr >= cacheCount ) {
                cachePtr = 0;
            }
        }
        
        return ptr;
    }
    
    private int read4(char[] buff){
    		return 1;
    }
    
}
