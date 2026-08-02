class Solution {

    public int solve(int i, int j, int[] piles, Integer[][] dp){
        if(i>j){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int first = piles[i] + Math.min(solve(i+2,j,piles,dp), solve(i+1,j-1,piles,dp));
        int last = piles[j] + Math.min(solve(i+1,j-1,piles,dp),solve(i,j-2,piles,dp));

        return dp[i][j] = Math.max(first,last);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int totalStones = 0;
        for(int i=0;i<n;i++){
            totalStones += piles[i];
        }
        Integer[][] dp = new Integer[n][n];
        int aliceScore = solve(0,n-1,piles,dp);
        int bobScore = totalStones - aliceScore;

        return aliceScore > bobScore;
    }
}