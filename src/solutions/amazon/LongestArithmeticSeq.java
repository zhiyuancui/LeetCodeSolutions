package solutions.amazon;

public class LongestArithmeticSeq {
    int res = 0;
    //array to keep differences and sequence length. dp[i][j] meaning is
    //sequence of length i and difference j. Because of the problem restrictions we can
    //allocate array for differences beforehand (0 <= A[i] <= 10000)
    int[][] dp = new int[A.length][20001];

    //set the right border of the sequence
        for (int i = 0; i < A.length; i++) {
        //start checking sequences by moving left border, so sequences from 0..i to i-1..i will
        //be checked
        for (int j = 0; j < i; j++) {
            //get the difference i and j elements, apply 10.000 shift so we can use array indexes
            int dif = (A[i] - A[j]) + 10000;
            //check if we have seen this difference before, if not - make it of length 2 (i and j makes at least
            //2 elements sequence)
            dp[i][dif] = (dp[j][dif] == 0 ? 1 : dp[j][dif]) + 1;
            //keep running max so we dont have to scan our dp matrix at the end
            res = Math.max(res, dp[i][dif]);
        }
    }
        return res;
}
