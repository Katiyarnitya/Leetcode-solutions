class Solution {
   public void dfs(int row, int col, int[][] imageCopy, int[][] image, int initialColor, int color, int[] deltaRow,
         int[] deltaCol) {

      imageCopy[row][col] = color;
      int m = image.length;
      int n = image[0].length;

      for (int i = 0; i < 4; i++) {
         int neighRow = row + deltaRow[i];
         int neighCol = col + deltaCol[i];
         if (neighRow >= 0 && neighRow < m && neighCol >= 0 && neighCol < n && image[neighRow][neighCol] == initialColor
               && imageCopy[neighRow][neighCol] != color) {
            dfs(neighRow, neighCol, imageCopy, image, initialColor, color, deltaRow, deltaCol);
         }
      }

   }

   public int[][] floodFill(int[][] image, int sr, int sc, int color) {

      int initialColor = image[sr][sc];
      int[][] imageCopy = image;

      int[] deltaRow = { -1, 0, +1, 0 };
      int[] deltaCol = { 0, +1, 0, -1 };

      dfs(sr, sc, imageCopy, image, initialColor, color, deltaRow, deltaCol);
      return imageCopy;
   }
}