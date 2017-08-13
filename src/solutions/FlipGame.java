package solutions;

public class FlipGame {

	/**
	 * 
	 * Flip Game II
	 * Reference to : https://leetcode.com/discuss/64344/theory-matters-from-backtracking-128ms-to-dp-0ms
	 * @param array
	 * @return
	 */
	private int len = 0;
	private char[] array;
	public boolean canWin(String s) {
        len = s.length();
        this.array = s.toCharArray();
        return canWin();
    }
	
	private boolean canWin(){
		for(int i = 0; i <= len -2; i++){
			if( array[i] == '+' && array[i+1] =='+'){
				array[i]='-';
				array[i+1]='-';
				boolean wins = !canWin();
				array[i] = '+';
				array[i+1] = '+';
				if( wins ){
					return true;
				}
			}
		}
		return false;
	}
}
