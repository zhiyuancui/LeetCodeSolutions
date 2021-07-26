package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumber {


	/**
	 *
	 * @param num
	 * @return
	 */
	public boolean isStrobogrammatic(String num) {
		if(num == null || num.length() == 0) {
			return false;
		}

		return isStrobogrammatic(num, 0, num.length() -1);
	}


	private boolean isStrobogrammatic(String num, int start, int end) {
		if(start > end) {
			return true;
		}
		if(start == end) {
			String sub = num.substring(start, end+1);

			return sub.equals("1") || sub.equals("0") || sub.equals("8");
		}

		if((num.charAt(start) == '8' && num.charAt(end) == '8') ||
				(num.charAt(start) == '1' && num.charAt(end) == '1') ||
				(num.charAt(start) == '9' && num.charAt(end) == '6') ||
				(num.charAt(start) == '6' && num.charAt(end) == '9') ||
				(num.charAt(start) == '0' && num.charAt(end) == '0')
		) {
			return isStrobogrammatic(num, start+1, end-1);
		} else {
			return false;
		}
	}

	/**
	 * 247 Strobogrammatic Number II
	 * @param n
	 * @return
	 */
	public List<String> findStrobogrammatic(int n) {
        return helper(n,n);
    }
	
	private List<String> helper(int n, int m){
		if (n == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}
	    if (n == 1) {
	    	return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    }

	    List<String> list = helper(n - 2, m);

	    List<String> res = new ArrayList<String>();

	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);

	        if (n != m) res.add("0" + s + "0");

	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }

	    return res;
	}
}
