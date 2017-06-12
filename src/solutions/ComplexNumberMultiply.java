package solutions;

import java.util.stream.Stream;

public class ComplexNumberMultiply {
	public String complexNumberMultiply(String a, String b) {
		int[] number1 = extraValue(a);
		int[] number2 = extraValue(b);
		
		int ac = number1[0] * number2[0];
		int bd = - (number1[1] * number2[1] );
		String acbd = (ac+bd)+"";
		
		int ad = number1[0] * number2[1];
		int bc = number1[1] * number2[0];
		
		String adbc = ad + bc == 0 ? "" : (ad+bc)+"i";
		
		return acbd +"+"+adbc;
	}

	private int[] extraValue(String number){
		
		number = number.substring(0,number.length() - 1);
		String[] parts = number.split("\\+");

		int a = parseFromString( parts[0] );
		int b = parseFromString( parts[1] );
			
		int[] result = new int[2];
		result[0] = a;
		result[1] = b;		
	    return result;
	}

	private int parseFromString( String number ){
		
		boolean neg = false;
		if ( number.startsWith("-") ) {
			neg = true;
		}

		return neg ? Integer.parseInt( number ) : Integer.parseInt( number );

	}
	
	/**
	 * Three Line Solution
	 * Reference to : https://discuss.leetcode.com/topic/84261/java-3-liner
	 */
	public String complexNumberMultiply2(String a, String b) {
	    int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(), 
	          coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
	    return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
	}
}
