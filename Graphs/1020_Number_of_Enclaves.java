class Pair {
   int row;
   int col;

   public Pair(int row, int col) {
      this.row = row;
      this.col = col;
   }
}

class Solution {
   public void bfs(int i, int j, int[][] vis, int[][] grid, int[] delRow, int[] delCol, Queue<Pair> Q) {
      int m = grid.length;
      int n = grid[0].length;

      vis[i][j] = 1;
      Q.add(new Pair(i, j));

      while (!Q.isEmpty()) {
         int row = Q.peek().row;
         int col = Q.peek().col;
         Q.poll();
         for (int k = 0; k < 4; k++) {
            int nrow = row + delRow[k];
            int ncol = col + delCol[k];
            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
               Q.add(new Pair(nrow, ncol));
               vis[nrow][ncol] = 1;
            }
         }
      }

   }

   public int numEnclaves(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;

      int[] delRow = { 0, 1, 0, -1 };
      int[] delCol = { -1, 0, 1, 0 };

      int[][] vis = new int[m][n];
      Queue<Pair> Q = new LinkedList<Pair>();

      // First and last col
      for (int i = 0; i < m; i++) {
         if (grid[i][0] == 1) {
            bfs(i, 0, vis, grid, delRow, delCol, Q);
         }
         if (grid[i][n - 1] == 1) {
            bfs(i, n - 1, vis, grid, delRow, delCol, Q);
         }
      }
      // first and last row
      for (int j = 0; j < n; j++) {
         if (grid[0][j] == 1) {
            bfs(0, j, vis, grid, delRow, delCol, Q);
         }
         if (grid[m - 1][j] == 1) {
            bfs(m - 1, j, vis, grid, delRow, delCol, Q);
         }
      }
      int count = 0;
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1 && vis[i][j] == 0) {
               count++;
            }
         }
      }
      return count;
   }
}