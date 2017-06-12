package solutions;


/**
 * Bit AND 1 which means keep the bits the same.
 * 
 * @author zhiyuan.cui
 *
 */
public class NumberComplement {

	public int findComplement(int num) {
        
        int mask = Integer.highestOneBit(num);
        mask = mask << 1;
        mask = mask - 1;
        num = ~ num;
        return num & mask;
    }
	
	private void printBit(int number) {
		for(int i = 0; i < 32; i++){
			System.out.print( number >> i & 1 );
		}
		System.out.println("");
	}
}
