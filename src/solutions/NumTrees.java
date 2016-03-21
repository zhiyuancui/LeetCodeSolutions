package solutions;

public class NumTrees {
	public int numTrees(int n) {
       int[] count = new int[n+2];
        count[0] = 1;
        count[1] = 1;
        
        for(int i=2;  i<= n; i++){
            for(int j=0; j<i; j++){
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n]; 
    }
}
