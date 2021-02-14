package solutions;

public class NumOfProvince {
    public int findCircleNum(int[][] isConnected) {
        int[] roots = new int[isConnected.length];

        for(int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        int row = isConnected.length;
        int col = isConnected[0].length;

        int count = roots.length;

        for(int i = 0; i < row; i++) {
            for(int j = i+1; j < col; j++) {
                if(isConnected[i][j] == 1) {
                    int rootI = getRoot(roots, i);
                    int rootJ = getRoot(roots, j);
                    if(rootI != rootJ) {
                        roots[rootI] = rootJ;
                        count--;
                    }
                }
            }
        }

        return count == 0 ? 1: count;
    }


    private int getRoot(int[] roots, int id) {
        while(id != roots[id]) {
            id = roots[id];
        }

        return id;
    }
}
