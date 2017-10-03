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
    
    /**
     *  Read N Characters Given Read4 II - Call multiple times
     * @param buf
     * @param n
     * @return
     */
    public int read2(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            if (i4 >= n4) {
                i4 = 0;
                n4 = read4(buf4);
                if (n4 == 0) break;
            }
            /* 1) i4<n4. 2) i4=0, n4>0 */
            buf[i++] = buf4[i4++];
        }
        return i;
    }
    
    private int read4(char[] buff){
    	return 1;
    }
    char[] buf4 = new char[4];
    int i4 = 0, n4 = 0;
}
