package solutions;

/**
 * 1151 Minimum Swaps to Group All 1's Together
 * 一次可以swap多个，而不是一个个慢慢swap
 */
public class MinimumSwapsToGroupOne {
    public int minSwaps(int[] data) {
        int totalOnes=0;
        for(int i:data){
            totalOnes+=i;
        }

        int currentOnes=0;
        int maxOnes=0;
        int left=0, right=0;
        while(right<data.length){
            currentOnes+=data[right];
            if(right-left+1>totalOnes){
                currentOnes-=data[left];
                left++;
            }
            maxOnes=Math.max(maxOnes,currentOnes);
            right++;
        }

        return totalOnes-maxOnes;
    }
}
