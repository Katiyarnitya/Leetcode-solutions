class Solution {
    static int rowL;
    static int colL;    
    public void DFS2(int r, int c, int[][] grid, int[] dr, int[] dc, boolean[][] visited){
        if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c] ==1 || visited[r][c]){
            return;
        }
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int newR = r+dr[i];
            int newC = c+dc[i];
            DFS2(newR, newC, grid, dr, dc, visited);
        }

    }public void DFS(int r, int c, int[][] grid, int[] dr, int[] dc){
        if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c] ==1){
            return;
        }
        grid[r][c] = 1;

        for(int i=0;i<4;i++){
            int newR = r+dr[i];
            int newC = c+dc[i];
            DFS(newR, newC, grid, dr, dc);
        }
    }

    public int closedIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (i == 0 || i == rowL - 1 || j == 0 || j == colL - 1) {
                    if(grid[i][j] == 0){
                        DFS(i,j,grid,dr,dc);
                    }
                }

            }
        }
        
        int islands = 0; 
        boolean[][] visited = new boolean[rowL][colL];
        for(int i=0; i<rowL; i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j] == 0  && !visited[i][j]){
                    DFS2(i,j,grid,dr,dc,visited);
                    islands++;
                }
            }
        }
        return islands;
    }
}