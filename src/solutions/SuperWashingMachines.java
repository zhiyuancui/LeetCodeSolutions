package solutions;

public class SuperWashingMachines {
	/**
	 * Reference to :http://www.cnblogs.com/grandyang/p/6648557.html
	 * @param machines
	 * @return
	 */
	public int findMinMoves(int[] machines) {
        int total = 0; 
        for(int i: machines) total+=i;
        if(total%machines.length!=0) return -1;
        int avg = total/machines.length, cnt = 0, max = 0;
        for(int load: machines){
            cnt += load-avg; //load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load-avg);
        }
        return max;
    }
}
