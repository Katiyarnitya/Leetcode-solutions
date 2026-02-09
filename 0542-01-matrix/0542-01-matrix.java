class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        Queue<int[]> q = new LinkedList<>();
        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    visited[i][j] = true;
                    q.offer(new int[]{i,j,0});
                }
            }
        }
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int dis = curr[2];
            if(mat[r][c]==1){
                result[r][c] = dis;
            }
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newC >= 0 && newR < n && newC < m && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    q.offer(new int[]{newR, newC,dis+1});
                }
            }

        }
        return result;
    }
}
// class Pair{
//     int row;
//     int col;
//     int dist;
//     public Pair(int row,int col,int dist){
//         this.row=row;
//         this.col=col;
//         this.dist=dist;
//     }
// }
// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;

//         int vis[][] = new int[m][n];
//         int dis[][] = new int[m][n];

//         Queue<Pair> Q = new LinkedList<Pair>();
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(mat[i][j]==0){
//                     Q.add(new Pair(i,j,0));
//                     vis[i][j]=1;
//                 }else{
//                     vis[i][j]=0;
//                 }
//             }
//         }
//         int[] deltaRow  = {+1,0,-1,0};
//         int[] deltaCol = {0,-1,0,+1};

//         while(!Q.isEmpty()){
//             int row = Q.peek().row;
//             int col = Q.peek().col;
//             int dist = Q.peek().dist;
//             Q.poll();
//             dis[row][col]=dist;

//             for(int i=0;i<4;i++){
//                 int neighRow = row + deltaRow[i];
//                 int neighCol = col + deltaCol[i]; 

//                 if(neighRow>=0 && neighRow<m && neighCol>=0 && neighCol<n && vis[neighRow][neighCol]==0){
//                     Q.add(new Pair(neighRow,neighCol,dist+1));
//                     vis[neighRow][neighCol]=1;
//                 }
//             }

//         }
//         return dis;
//     }
// }