class Solution {
    int n, m;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public void dfs(int r, int c, int[][] grid, boolean[][] visited){
        visited[r][c] = true;

        for(int i=0;i<4;i++){
            int newR = r + dr[i];
            int newC = c + dc[i];

            if(newR>=0 && newC>=0 && newR<n && newC<m && !visited[newR][newC] && grid[newR][newC]==1){
                visited[newR][newC] = true;
                dfs(newR, newC, grid,visited);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        boolean found = false;
        for(int i = 0; i < n && !found; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid, visited);
                    found = true;
                    break;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0;j<m; j++){
                if(grid[i][j]==1 && visited[i][j]){
                    q.add(new int[] {i,j,0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];

            for(int i=0;i<4;i++){
                int newR = r + dr[i];
                int newC = c + dc[i];

                if(newR>=0 && newC>=0 && newR<n && newC<m && !visited[newR][newC]){
                    if(grid[newR][newC] == 1){
                        return dis;
                    }
                    visited[newR][newC] = true;
                    q.offer(new int[]{newR,newC,dis+1});
                }
            }
        }
        return 0;
    }
}