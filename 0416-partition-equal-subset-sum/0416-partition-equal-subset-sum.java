class Solution {
    public boolean solve(int idx, int k,int[] nums, int[][]dp){
        if(k == 0) return true;
        if(idx<0){
            return false;
        }
        if(dp[idx][k] != -1) return dp[idx][k]==1;
        boolean take = false;
        if(nums[idx]<=k){
            take = solve(idx-1,k-nums[idx],nums, dp);
        }
        boolean notTake = solve(idx-1,k,nums,dp);
        dp[idx][k] = (take || notTake) ? 1 : 0;   // boolean → int
        return take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2 !=0) return false;
        int k = sum/2;
        int dp[][] = new int[n][k+1];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(n-1,k,nums,dp);
    }
}