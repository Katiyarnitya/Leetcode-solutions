class Pair {
   int row;
   int col;
   int dist;

   public Pair(int row, int col, int dist) {
      this.row = row;
      this.col = col;
      this.dist = dist;
   }
}

class Solution {
   public int[][] updateMatrix(int[][] mat) {
      int m = mat.length;
      int n = mat[0].length;

      int vis[][] = new int[m][n];
      int dis[][] = new int[m][n];

      Queue<Pair> Q = new LinkedList<Pair>();
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (mat[i][j] == 0) {
               Q.add(new Pair(i, j, 0));
               vis[i][j] = 1;
            } else {
               vis[i][j] = 0;
            }
         }
      }
      int[] deltaRow = { +1, 0, -1, 0 };
      int[] deltaCol = { 0, -1, 0, +1 };

      while (!Q.isEmpty()) {
         int row = Q.peek().row;
         int col = Q.peek().col;
         int dist = Q.peek().dist;
         Q.poll();
         dis[row][col] = dist;

         for (int i = 0; i < 4; i++) {
            int neighRow = row + deltaRow[i];
            int neighCol = col + deltaCol[i];

            if (neighRow >= 0 && neighRow < m && neighCol >= 0 && neighCol < n && vis[neighRow][neighCol] == 0) {
               Q.add(new Pair(neighRow, neighCol, dist + 1));
               vis[neighRow][neighCol] = 1;
            }
         }

      }
      return dis;
   }
}