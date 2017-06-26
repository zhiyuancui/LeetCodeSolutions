package solutions;

public class StudentAttendanceRecord {
	public boolean checkRecord(String s) {
        int Acount = 0;
        int Lcount = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if( s.charAt(i) == 'A' ) {
                Acount++;
                Lcount = 0;
            } else if( s.charAt(i) == 'L' ) {
                Lcount++;
            } else {
                Lcount = 0;
            }
            if( Acount > 1  || Lcount > 2) {
                return false;
            }
        }
    
        
        
        return true;
    }
	
	/**
	 * Student Attendance Record II
	 * @param n
	 * @return
	 */
	public int checkRecord(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];
    
        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }
}
