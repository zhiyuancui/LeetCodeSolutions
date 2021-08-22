package solutions;

/**
 * 1861 Rotating the Box
 */
public class RotateBox {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;

        char[][] ans = new char[col][row];

        for(int i = 0; i < row; i++) {
            int pos = col - 1;
            for(int j = col - 1; j >= 0; j--) {
                if(box[i][j] == '#') {
                    box[i][pos] = '#';
                    pos--;

                    if(pos != j-1) {
                        box[i][j] = '.';
                    }
                } else if(box[i][j] =='*') {
                    pos = j - 1;
                }
            }
        }


        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ans[j][row - 1- i] = box[i][j];
            }
        }

        return ans;
    }
}
