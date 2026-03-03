class Solution {
    static int[][] dp;
    static final int MOD = 1000000007;
    public int helper(int idx, int sum, int n, int k, int target){

        if(sum > target) return 0;
        if(idx==n){
            if(target==sum){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[idx][sum] != -1) return dp[idx][sum];
        int ways = 0;
        for(int i=1; i<=k; i++){
           ways = (ways + helper(idx + 1, sum + i, n, k, target)) % MOD;
        }
        return dp[idx][sum] = ways;
    }    
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }
        return helper(0,0,n,k,target);
    }
}