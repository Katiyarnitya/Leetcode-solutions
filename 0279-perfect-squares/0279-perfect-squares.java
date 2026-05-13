class Solution {
    public static int solve(int num, int sum, Integer[][]dp){
        if(sum<=0) return 0;
        if(num<=0) return Integer.MAX_VALUE;

        if(dp[num][sum] != null) return dp[num][sum];
        // 2 options

        int take = Integer.MAX_VALUE;
        if(num*num <= sum){
            take = 1 + solve(num, sum-(num*num),dp);
        }
        int nottake = 0 + solve(num-1, sum, dp);

        return dp[num][sum] =  Math.min(take,nottake);
    }
    public int numSquares(int n) {
        
        int num = (int) Math.sqrt(n);

        Integer[][] dp = new Integer[num+1][n+1];
        return solve(num,n,dp);
    }
}                       