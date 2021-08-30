package solutions;

/**
 * 134 Gas Station
 */
public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int total = 0;
        int index = 0;
        int sum = 0;
        
        for(int i = 0; i < gas.length; i++)
        {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if( sum < 0 )
            {
                index = i+1;
                sum = 0;
            }
            
        }
        
        
        return total < 0 ? -1:index;
    }
}
