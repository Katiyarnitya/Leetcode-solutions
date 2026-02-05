class Solution {
    static int rowL;
    static int colL;
    public int DFS(int r, int c, int[][] grid,boolean[][] visited, int[] dr, int[] dc){
        if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c] == 0){
            return 1;
        }
        if(visited[r][c]) return 0;

        int peri =0;
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            peri += DFS(newR, newC, grid,visited,dr,dc);

        }
        return peri;
    }
    public int islandPerimeter(int[][] grid) {
        
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] visited = new boolean[rowL][colL];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        int ans = 0;
        for(int i=0;i<rowL;i++){
            for(int j=0;j<colL;j++){
                if(grid[i][j] == 1){
                   ans +=  DFS(i,j,grid,visited,dr,dc);
                   break;
                }
            }
        }
        return ans;
    }
}