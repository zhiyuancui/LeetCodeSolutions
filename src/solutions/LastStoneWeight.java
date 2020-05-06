package solutions;

public class LastStoneWeight {

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i =0;i<stones.length;i++){
            sum+=stones[i];
        }
        int sum1=0;
        int sum2=0;
        Integer [][] dp =  new Integer[stones.length][sum+1];
        int result = aux(dp,0,0,0,stones);
        return result;
    }

    public int aux(Integer [][] dp,int sum1, int sum2,int i,int [] stones){
        if(i<stones.length){
            if(dp[i][Math.abs(sum1-sum2)]==null){
                dp[i][Math.abs(sum1-sum2)]= Math.min(aux(dp,sum1+stones[i],sum2,i+1,stones),aux(dp,sum1,sum2+stones[i],i+1,stones));
            }return dp[i][Math.abs(sum1-sum2)];
        }
        return Math.abs(sum1-sum2);
    }
}

