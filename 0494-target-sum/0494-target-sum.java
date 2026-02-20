class Solution {
    public int countSubsets(int idx, int tar, int[] nums){
        if(idx==0){
            if(tar==0 && nums[0]==0) return 2;
            if(tar ==0 || nums[0] == tar) return 1;
            return 0;
        }

        int notTake = countSubsets(idx-1,tar,nums);
        int take = 0;
        if(nums[idx]<=tar){
            take =countSubsets(idx-1, tar-nums[idx],nums);
        }

        return take+notTake;
    }
    public int findTargetSumWays(int[] nums, int target) {
        // Similar to no. of partitions whoose diff is equal to the target
      int n = nums.length;
      int totSum = 0;
      for(int i : nums){
        totSum +=i;
      } 
      if (totSum - target < 0 || (totSum - target) % 2 != 0)
        return 0;
      int tar = (totSum-target)/2;
      return countSubsets(n-1,tar,nums); 
    }
}