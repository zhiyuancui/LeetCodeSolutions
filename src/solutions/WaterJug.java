package solutions;

/**
 * 365 Water and Jug Problem
 * https://leetcode-cn.com/problems/water-and-jug-problem/solution/shui-hu-wen-ti-by-leetcode-solution/
 */
public class WaterJug {
	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;
        //case x or y is zero
        if( jug1Capacity == targetCapacity || jug2Capacity == targetCapacity || jug1Capacity + jug2Capacity == targetCapacity ) return true;
        
        //get GCD, then we can use the property of 
        return targetCapacity%GCD(jug1Capacity, jug2Capacity) == 0;
    }
    
    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}
