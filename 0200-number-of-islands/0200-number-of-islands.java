class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public void dfs(int r, int c, boolean[][]vis, char[][]grid, int m, int n){

        vis[r][c] = true;

        for(int i=0;i<4;i++){
            int nR = r + dr[i];
            int nC = c + dc[i];

            if(nR>=0 && nR<m && nC>=0 && nC<n && !vis[nR][nC] && grid[nR][nC]=='1'){
                dfs(nR,nC,vis,grid,m,n);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        int islands = 0;
        for(int i=0;i<m;i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    islands++;
                    dfs(i,j,vis,grid,m,n);
                }
            }
        }
        return islands;
    }
}