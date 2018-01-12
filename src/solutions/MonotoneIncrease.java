package solutions;
/**
 * 
 * @author zhiyuan.cui
 *
 */
public class MonotoneIncrease {
	public int monotoneIncreasingDigits(int N) {
        if(N<=9)
            return N;
        char[] array = Integer.toString(N).toCharArray();

        int mark = array.length;
        for(int i = array.length-1;i>0;i--){
            if(array[i]<array[i-1]){
                mark = i-1;
                array[i-1]--;
            }
        }
        for(int i = mark+1;i<array.length;i++){
            array[i] = '9';
        }
        return Integer.parseInt(new String(array));
    }
}
