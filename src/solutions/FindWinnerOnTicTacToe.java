package solutions;

/**
 * 1254 Find Winner on Tic Tac Toe Game
 */
public class FindWinnerOnTicTacToe {
    public String tictactoe(int[][] moves) {
        int[] aRow = new int[3], aCol = new int[3], bRow = new int[3], bCol = new int[3];
        int  aD1 = 0, aD2 = 0, bD1 = 0, bD2 = 0;
        for (int i = 0; i < moves.length; ++i) {
            int r = moves[i][0], c = moves[i][1];
            if (i % 2 == 1) {
                if (++bRow[r] == 3 || ++bCol[c] == 3 || r == c && ++bD1 == 3 || r + c == 2 && ++bD2 == 3) return "B";
            }else {
                if (++aRow[r] == 3 || ++aCol[c] == 3 || r == c && ++aD1 == 3 || r + c == 2 && ++aD2 == 3) return "A";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}
