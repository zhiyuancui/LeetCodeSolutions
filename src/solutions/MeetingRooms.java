package solutions;

import java.util.Arrays;

import util.Interval;

/**
 * 252 Meeting Rooms
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }

        Arrays.sort(intervals, (a,b)->a[0] - b[0]);

        for(int i = 0; i < intervals.length -1; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }

        return true;
    }
	
}
