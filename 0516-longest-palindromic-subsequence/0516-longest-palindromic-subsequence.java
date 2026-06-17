class Solution {
    public int lcs(int i, int j, String s1, String s2, int[][] dp){
        if(i<0 || j<0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        // Match
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s1,s2,dp);
        }

        return dp[i][j] = 0 + Math.max(lcs(i-1,j,s1,s2,dp), lcs(i,j-1,s1,s2,dp));
    }
    public int longestPalindromeSubseq(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lcs(n-1,n-1,s,reversed,dp);
    }
}