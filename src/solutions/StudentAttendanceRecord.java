package solutions;

/**
 * 551. Student Attendance Record I
 */
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
}
