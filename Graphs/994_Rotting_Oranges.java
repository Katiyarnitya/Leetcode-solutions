class Pair {
   int row;
   int col;
   int time;

   public Pair(int row, int col, int time) {
      this.row = row;
      this.col = col;
      this.time = time;
   }
}

class Solution {
   public int orangesRotting(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[][] vis = new int[m][n];
      Queue<Pair> Q = new LinkedList<Pair>();
      int cntFresh = 0;

      // Pushing the rotten oranges in the queue
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == 2) {
               Q.add(new Pair(i, j, 0));
               vis[i][j] = 2;
            } else {
               vis[i][j] = 0;
            }
            if (grid[i][j] == 1) {
               cntFresh++;
            }
         }
      }

      int tm = 0;
      int[] deltaRow = { -1, 0, 1, 0 }; // Up, Right, Down, Left
      int[] deltaCol = { 0, 1, 0, -1 };

      while (!Q.isEmpty()) {
         int row = Q.peek().row;
         int col = Q.peek().col;
         int t = Q.peek().time;
         Q.poll();
         tm = Math.max(tm, t);

         for (int k = 0; k < 4; k++) {

            int neighRow = row + deltaRow[k];
            int neighCol = col + deltaCol[k];

            if ((neighRow >= 0 && neighRow < m) && (neighCol >= 0 && neighCol < n) && vis[neighRow][neighCol] != 2
                  && grid[neighRow][neighCol] == 1) {
               Q.offer(new Pair(neighRow, neighCol, t + 1));
               vis[neighRow][neighCol] = 2;
            }
         }
      }
      // count can also be used to keep track, this will eliminate this loop
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (vis[i][j] != 2 && grid[i][j] == 1) {
               return -1;
            }
         }
      }
      return tm;
   }

}