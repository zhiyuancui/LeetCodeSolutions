package solutions;

/**
 * 766 Teoplitz Matrix
 */
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i = row -1; i >= 0; i--) {
            int num = matrix[i][0];
            int x = i;
            int y = 0;
            //System.out.println(x+","+y);
            while(x >= 0 && x < row && y >= 0 && y < col) {
                if(num != matrix[x][y]) {
                    //System.out.println("("+x+","+y+"):"+num);
                    return false;
                }
                x++;
                y++;
            }
        }

        for(int j = 0; j < col; j++) {
            int num = matrix[0][j];
            int x = 0;
            int y = j;

            while(x >= 0 && x < row && y >= 0 && y < col) {
                if(num != matrix[x][y]) {
                    //System.out.println("("+x+","+y+"):"+num);
                    return false;
                }
                x++;
                y++;
            }
        }


        return true;
    }
}
