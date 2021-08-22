package solutions;

/**
 * 573 Squirrel Simulation
 */
public class SquirrelSimulation {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int n = nuts.length;
        int[] nutToTree = new int[n];
        int[] nutToSquirrel = new int[n];
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            nutToTree[i] = Math.abs(nuts[i][0] - tree[0]) + Math.abs(nuts[i][1] - tree[1]);
            sum += nutToTree[i] * 2;
            nutToSquirrel[i] = Math.abs(nuts[i][0] - squirrel[0]) + Math.abs(nuts[i][1] - squirrel[1]);
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int dist = sum + nutToSquirrel[i] - nutToTree[i];
            min = Math.min(min, dist);
        }
        
        return min;
    }
}
