class Solution {
    static int rLen;
    static int cLen;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static char[] direction = {'U','D','L','R'};
    static class Pair{
        int row;
        int col;
        public Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    public void BFS(int r, int c, boolean[][] vis, char[][] grid){
        vis[r][c] = true;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));

        while(!q.isEmpty()){
            Pair node = q.poll();
            int R = node.row;
            int C = node.col;

            for(int i=0;i<4;i++){
                int newR = R + dr[i];
                int newC = C + dc[i];

                if(newR>=0 && newC>=0 && newR < rLen && newC<cLen && !vis[newR][newC] && grid[newR][newC]=='1'){
                    vis[newR][newC]= true;
                    q.offer(new Pair(newR, newC));
                }
            }
        }

    }
    public int numIslands(char[][] grid) {
        rLen = grid.length;
        cLen = grid[0].length;

        boolean[][] vis = new boolean[rLen][cLen];
        int components = 0;
        for(int i=0;i<rLen;i++){
            for(int j=0;j<cLen;j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    components++;
                    BFS(i,j,vis,grid);
                }
            }
        }
        return components;
    }
}
// class Solution {
//     static int rowL;
//     static int colL;
//     public void DFS( int r, int c, char[][]grid, int[] dr, int[] dc){
//         if(r<0 || c<0 || r>=rowL || c>=colL || grid[r][c]=='0'){
//             return;
//         }

//         grid[r][c] = '0';
//         for(int i=0;i<dr.length;i++){
//             int newR = r+dr[i];
//             int newC = c+dc[i];
//             DFS(newR, newC, grid,dr,dc);
//         }
//     }
//     public int numIslands(char[][] grid) {
        
//         rowL = grid.length;
//         colL = grid[0].length;

//         int[] dr = {-1,1,0,0};
//         int[] dc = {0,0,-1,1};
//         int components = 0;
//         for(int i=0;i<rowL;i++){
//             for(int j=0;j<colL;j++){
//                 if(grid[i][j]=='1'){
//                     DFS(i,j,grid,dr,dc);
//                     components++;
//                 }
//             }
//         }
//         return components;
//     }
// }
// class Pair{
//     int first;
//     int second;
//     public Pair(int first,int second){
//         this.first=first;
//         this.second=second;
//     }
// }
// class Solution {
//     public void bfs(int i,int j,char[][] grid,boolean[][] vis){
//         int m = grid.length;
//         int n = grid[0].length;
//         Queue<Pair> Q = new LinkedList<Pair>();
//         Q.offer(new Pair(i,j));
//         vis[i][j]=true;// row and col passed from main funtion for which we need to apply bfs
//         int[] deltaRow = {-1, 0, 1, 0};  // Up, Right, Down, Left
//         int[] deltaCol = {0, 1, 0, -1};
//         while(!Q.isEmpty()){
//             int row = Q.peek().first;
//             int col = Q.peek().second;
//             Q.remove();
//             for(int k = 0; k < 4; k++){
//                 int neighRow = row + deltaRow[k];
//                 int neighCol = col + deltaCol[k];
//                 if((neighRow>=0 && neighRow<m ) && (neighCol>=0 && neighCol<n ) && grid[neighRow][neighCol]=='1' && vis[neighRow][neighCol]==false){
//                     Q.offer(new Pair(neighRow,neighCol));
//                     vis[neighRow][neighCol]=true;
//                 }
//             }
//         }
//     }
//     public int numIslands(char[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         int count = 0;
//         boolean[][] vis = new boolean[m][n];
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]=='1' && vis[i][j]==false){
//                     count++;
//                     bfs(i,j,grid,vis);
//                 }
//             }
//         }
//         return count;
//     }
//     }