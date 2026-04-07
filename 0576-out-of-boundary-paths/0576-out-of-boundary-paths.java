class Solution {
    static int mod = 1_000_000_007;
    static Integer[][][] dp;
    public static long solve(int i, int j, int movesRemaining, int m, int n){
        
        if(i<0 || j<0 || i>=m || j>=n){
            return 1;
        }
         if(movesRemaining ==0){
            return 0;
        }
        if(dp[i][j][movesRemaining] != null) return dp[i][j][movesRemaining];
        long up = solve(i-1,j,movesRemaining-1,m,n);
        long down = solve(i+1,j,movesRemaining-1,m,n);
        long left = solve(i,j-1,movesRemaining-1,m,n);
        long right = solve(i,j+1,movesRemaining-1,m,n);

        return dp[i][j][movesRemaining] = (int) ((up+down+left+right)%mod);
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new Integer[m][n][maxMove+1];

        return (int)solve(startRow, startColumn, maxMove,m,n);
    }
}