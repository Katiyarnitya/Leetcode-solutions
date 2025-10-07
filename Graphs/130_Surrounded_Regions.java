class Solution {
   public void dfs(int row, int col, int[][] vis, char[][] board, int[] delRow, int[] delCol) {
      int m = board.length;
      int n = board[0].length;

      vis[row][col] = 1;
      for (int i = 0; i < 4; i++) {

         int nRow = row + delRow[i];
         int nCol = col + delCol[i];

         if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
            dfs(nRow, nCol, vis, board, delRow, delCol);
         }

      }
   }

   public void solve(char[][] board) {
      int m = board.length;
      int n = board[0].length;

      int[] delRow = { 0, 1, 0, -1 };
      int[] delCol = { -1, 0, 1, 0 };

      int[][] vis = new int[m][n];

      // First and last col
      for (int i = 0; i < m; i++) {
         if (board[i][0] == 'O') {
            dfs(i, 0, vis, board, delRow, delCol);
         }
         if (board[i][n - 1] == 'O') {
            dfs(i, n - 1, vis, board, delRow, delCol);
         }
      }
      // first and last row
      for (int j = 0; j < n; j++) {
         if (board[0][j] == 'O') {
            dfs(0, j, vis, board, delRow, delCol);
         }
         if (board[m - 1][j] == 'O') {
            dfs(m - 1, j, vis, board, delRow, delCol);
         }
      }

      // Replacing

      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            if (board[i][j] == 'O' && vis[i][j] == 0) {
               board[i][j] = 'X';
            }
         }
      }

   }
}