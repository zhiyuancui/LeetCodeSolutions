package solutions;

public class ZumaGames {
	int MAXCOUNT = 6;
	    
	    public int findMinStep(String board, String hand) {
	        int[] handCount = new int[32];
	        for (int i = 0; i < hand.length(); ++i) {
	        	++handCount[hand.charAt(i) - 'A'];
	        }
	        int rs = helper(board + "#", handCount);  // append a "#" to avoid special process while j==board.length, make the code shorter.
	        return rs == MAXCOUNT ? -1 : rs;
	    }
	    
	    private int helper(String s, int[] h) {
	        s = removeConsecutive(s);     
	        if (s.equals("#")) {
	        		return 0;
	        }
	        int  rs = MAXCOUNT, need = 0;
	        for (int i = 0, j = 0 ; j < s.length(); ++j) {
		        	if (s.charAt(j) == s.charAt(i)) continue;
		        	need = 3 - (j - i);     //balls need to remove current consecutive balls.
		        	if (h[s.charAt(i) - 'A'] >= need) {
		        		h[s.charAt(i) - 'A'] -= need;
		        		rs = Math.min(rs, need + helper(s.substring(0, i) + s.substring(j), h));
		        		h[s.charAt(i) - 'A'] += need;
		        	}
		        	i = j;
	        }
	        return rs;
	    }
	
	private String removeConsecutive(String board) {
	    for (int i = 0, j = 0; j < board.length(); ++j) {
	        if (board.charAt(j) == board.charAt(i)) continue;
	        if (j - i >= 3) return removeConsecutive(board.substring(0, i) + board.substring(j));
	        else i = j;
	    }
	    return board;
	}
}
