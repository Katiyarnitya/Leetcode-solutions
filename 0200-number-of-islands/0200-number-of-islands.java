class Solution {
    static int rowL;
    static int colL;
    public void DFS( int r, int c, char[][]grid, int[] dr, int[] dc){
        if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c]=='0'){
            return;
        }

        grid[r][c] = '0';
        for(int i=0;i<dr.length;i++){
            int newR = r+dr[i];
            int newC = c+dc[i];
            DFS(newR, newC, grid,dr,dc);
        }
    }
    public int numIslands(char[][] grid) {
        
        rowL = grid.length;
        colL = grid[0].length;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int components = 0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j]=='1'){
                    DFS(i,j,grid,dr,dc);
                    components++;
                }
            }
        }
        return components;
    }
}