class Solution {
    int n;
    Integer[][][][] dp;
    public int solve(int r1, int c1, int r2, int c2, int[][] grid){
   
        
        if(r1 < 0 || r2 < 0 || c1 < 0 || c2 < 0 || r1 >= n || r2 >= n || c1 >= n || c2 >= n) {
            return Integer.MIN_VALUE;
        }
        if(grid[r1][c1] == -1 || grid[r2][c2] == -1){
            return Integer.MIN_VALUE;
        }
        if(r1==r2 && c1==c2 && r1==n-1 && c1==n-1){
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2][c2] != null) return dp[r1][c1][r2][c2];
        
        int cherry = grid[r1][c1];
        if(r1!=r2){
            cherry+=grid[r2][c2];
        }
        // RR
        int RR =  solve(r1, c1+1, r2,c2+1, grid);

        // DD
        int DD = solve(r1+1, c1, r2+1,c2, grid);

        //RD
        int RD = solve(r1, c1+1, r2+1,c2, grid);

        //DR
        int DR = solve(r1+1, c1, r2,c2+1, grid);

        int next = Math.max(RR,Math.max(DD,Math.max(RD,DR)));
        if(next == Integer.MIN_VALUE){
            return dp[r1][c1][r2][c2] = Integer.MIN_VALUE;
        }
        return dp[r1][c1][r2][c2] = cherry + next;
    }
    public int cherryPickup(int[][] grid) {

        n = grid.length;
        dp = new Integer[n][n][n][n];
        if(grid[0][0]==-1 || grid[n-1][n-1] ==-1) return 0;
         
        int ans = solve(0,0,0,0,grid);

        return Math.max(0, ans);
    }
}

// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int n = grid.length;
//         int[][][][] dp = new int[n][n][n][n];

        
//         for (int i = 0; i < n; i++)
//             for (int j = 0; j < n; j++)
//                 for (int k = 0; k < n; k++)
//                     for (int l = 0; l < n; l++)
//                         dp[i][j][k][l] = -1;

//         int result = solve(0, 0, 0, 0, n, grid, dp);
//         return Math.max(result, 0);
//     }

//     private int solve(int r1, int c1, int r2, int c2, int n, int[][] grid, int[][][][] dp) {
        
//         if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return -1000000;
//         if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return -1000000;

       
//         if (r1 == n - 1 && c1 == n - 1) return grid[r1][c1];

//         if (dp[r1][c1][r2][c2] != -1) return dp[r1][c1][r2][c2];

//         int cherries = grid[r1][c1];
//         if (r1 != r2 || c1 != c2) cherries += grid[r2][c2];

//         // 4 possible moves
//         int maxNext = Math.max(
//             Math.max(solve(r1 + 1, c1, r2 + 1, c2, n, grid, dp), 
//                      solve(r1 + 1, c1, r2, c2 + 1, n, grid, dp)),
//             Math.max(solve(r1, c1 + 1, r2 + 1, c2, n, grid, dp),
//                      solve(r1, c1 + 1, r2, c2 + 1, n, grid, dp))
//         );

//         cherries += maxNext;
//         dp[r1][c1][r2][c2] = cherries;
//         return cherries;
//     }
// }
