class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public boolean dfs(int r, int c, boolean[][] vis, int[][] parentR, int[][] parentC, char[][] grid, int m , int n){
        vis[r][c] = true;

        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if( nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == grid[r][c]){
                if(!vis[nr][nc]){
                    parentR[nr][nc] = r;
                    parentC[nr][nc] = c;
                    if(dfs(nr,nc,vis,parentR,parentC,grid,m,n)){
                        return true;
                    }
                }else{
                    if(parentR[r][c] != nr || parentC[r][c]!=nc){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;


        boolean[][] vis = new boolean[m][n];

        int[][] parentR = new int[m][n];
        int[][] parentC = new int[m][n];

        for(int[] row : parentR){
            Arrays.fill(row,-1);
        }

        for(int[] row : parentC){
            Arrays.fill(row,-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]){
                    if(dfs(i,j,vis,parentR, parentC,grid,m,n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}