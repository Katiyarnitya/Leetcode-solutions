class Solution {
    static int m;
    static int n;
    public int solve(int i, int j, int remaining, int[][] coins, Integer[][][] dp){
        
        if(i>=m || j>=n) return Integer.MIN_VALUE;
        if(i==m-1 && j==n-1){
            if(coins[i][j] < 0 && remaining>0) return 0;
            return coins[i][j];
        }
        if(dp[i][j][remaining] != null) return dp[i][j][remaining];

        int take = coins[i][j] + Math.max(solve(i+1,j,remaining, coins,dp) , solve(i,j+1, remaining,coins,dp));
        int notTake = Integer.MIN_VALUE;

        if(coins[i][j] < 0 && remaining>0){
            notTake = 0 + Math.max(solve(i+1,j,remaining-1,coins,dp), solve(i,j+1, remaining-1, coins,dp));
        }

        return dp[i][j][remaining] = Math.max(take,notTake);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        Integer[][][] dp = new Integer[m][n][3];
        
        return solve(0,0,2,coins,dp);
    }
} 