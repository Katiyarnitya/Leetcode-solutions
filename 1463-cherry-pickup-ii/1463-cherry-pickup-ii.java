class Solution {
    int n;
    int m;
    Integer[][][] dp;

    public int solve(int r, int c1, int c2, int[][] grid){

        if(r<0 || r>=n || c1<0 || c1>=m || c2<0 || c2>=m){
            return Integer.MIN_VALUE;
        }
        if(dp[r][c1][c2] != null) return dp[r][c1][c2];

        if(r==n-1){
            if(c1!=c2){
                return grid[r][c1] + grid[r][c2];
            }else{
                return grid[r][c1];
            }
            
        }
        int cherries = grid[r][c1];
        if(c1!=c2){
            cherries += grid[r][c2];
        }
        int maxi = Integer.MIN_VALUE;

        for(int d1 =-1 ; d1<=1; d1++){
            for(int d2=-1; d2<=1; d2++){
                maxi = Math.max(maxi, solve(r+1, c1+d1, c2+d2, grid));
            }
        }
       return dp[r][c1][c2] = maxi + cherries;
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        dp = new Integer[n][m][m];
        return Math.max(0,solve(0,0,m-1,grid));
    }
}