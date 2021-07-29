package solutions;

/**
 * Spiral Matrix III
 */
public class SpiralMatrixIII {
    int[] dr = new int[]{0,1,0,-1};
    int[] dc = new int[]{1,0,-1,0};

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];

        int count = 1;

        result[0][0] = rStart;
        result[0][1] = cStart;

        if(rows * cols == 1) {
            return result;
        }

        for(int k = 1; k < 2*(rows+cols); k+=2) {
            for(int i = 0; i < dr.length; i++) {
                int dk = k + (i/2);
                for(int j = 0; j < dk; j++) {
                    rStart += dr[i];
                    cStart += dc[i];

                    if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[count] = new int[]{rStart, cStart};
                        count++;
                        if(count == rows * cols) {
                            return result;
                        }
                    }
                }
            }
        }

        return null;

    }
}
