package solutions;

public class CanWinNim {
	public boolean canWinNim(int n){
		if( n < 0 )
	     {
	         return false;
	         
	     }
	     
	     return n % 4 != 0;
	}
}
