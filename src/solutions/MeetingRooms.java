package solutions;

import java.util.Arrays;

import util.Interval;

public class MeetingRooms {

    /***
     * 253 Meeting Rooms II
     * @param intervals
     * @return
     */
	public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for(int i = 0; i < intervals.length; i++){
        	starts[i] = intervals[i].start;
        	ends[i] = intervals[i].end;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
	
	public boolean canAttendMeetings(Interval[] intervals) {
        
        if( intervals == null || intervals.length == 0 ) {
            return true;
        }
        
        Arrays.sort(intervals, (a,b) -> {
            return a.start - b.start;
        });
        
        for(int i = 1; i < intervals.length; i++) {
            if( intervals[i].start < intervals[i-1].end ) 
            {
                return false;
            }
        }
        
        return true;
    
    }
	
}
