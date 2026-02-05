class Solution {
    static int rowL;
    static int colL;

    public int DFS(int r, int c, boolean[][] visited, int[][] grid, int[] dr, int[] dc){
        if(r<0 || c<0 || r>=rowL || c>=colL || visited[r][c] || grid[r][c]==0){
            return 0;
        }
        visited[r][c] = true;
        int count=1;

        for(int i=0;i<4;i++){
            int newR = r + dr[i];
            int newC = c + dc[i];
            count = count + DFS(newR,newC,visited,grid, dr,dc);
        }
        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        rowL = grid.length;
        colL = grid[0].length;
        boolean[][] visited = new boolean[rowL][colL];
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        int maxArea=0;
        for(int i=0;i<rowL;i++){
            for(int j=0; j<colL;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, DFS(i,j,visited,grid,dr,dc));
                }
            }
        }
        return maxArea;
    }
}