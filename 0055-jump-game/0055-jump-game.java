class Solution {
    Boolean dp[];
    public boolean solve(int idx, int n, int[] nums){
        if(idx==n-1) return true;
        if(idx>=n) return false;
        if(dp[idx] != null) return dp[idx];

        boolean result = false;
        for(int i=1;i<=nums[idx]; i++){
            result = result || solve(idx+i,n,nums);
        }
        return dp[idx] = result;
    }
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) return true;

        // dp = new Boolean[n];
        // return solve(0,n,nums);

        int maxReachable = nums[0];
        for(int i=1;i<n;i++){

            if(i>maxReachable) return false;
            if(i==n-1) return true;

            maxReachable = Math.max(maxReachable, i + nums[i]);
        }
        return true;
    }
}