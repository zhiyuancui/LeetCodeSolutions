package solutions;

public class PartitionToKSubsets {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num:nums)sum += num;
        if(k <= 0 || sum%k != 0)return false;
        int[] visited = new int[nums.length];
        return canPartition(nums, visited, 0, k, 0, 0, sum/k);
    }
    
    public boolean canPartition(int[] nums, int[] visited, int start_index, int k, int cur_sum, int cur_num, int target){
        if(k==1)return true;
        if(cur_sum == target && cur_num>0) {
            return canPartition(nums, visited, 0, k-1, 0, 0, target);
        }
        
        for(int i = start_index; i<nums.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if( canPartition(nums, visited, i+1, k, cur_sum + nums[i], cur_num++, target) ){
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}
