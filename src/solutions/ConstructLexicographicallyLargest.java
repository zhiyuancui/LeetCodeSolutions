package solutions;

public class ConstructLexicographicallyLargest {
    public int[] constructDistancedSequence(int n) {
        if(n <= 0) {
            return new int[0];
        }

        int[] nums = new int[n*2-1];
        boolean[] visited = new boolean[n+1];

        placeNumber(nums, 0, visited,n);

        return nums;
    }

    private boolean placeNumber(int[] nums, int pos, boolean[] visited, int n) {
        if(pos == nums.length) {
            return true;
        }

        if(nums[pos] != 0) {
            return placeNumber(nums, pos+1, visited, n);
        } else {

            for(int i = n; i>= 1; i--) {
                if(visited[i]) continue;
                visited[i] = true;
                nums[pos] = i;
                if(i==1) {
                    if(placeNumber(nums, pos+1, visited, n)) {
                        return true;
                    }
                } else if(pos + i < nums.length && nums[pos+i] == 0){
                    nums[pos+i] = i;
                    if(placeNumber(nums, pos+1, visited, n)) {
                        return true;
                    }
                    nums[pos+i] = 0;
                }

                nums[pos] = 0;
                visited[i] = false;
            }
        }

        return false;
    }
}
