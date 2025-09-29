class Solution {
   public List<Integer> spiralOrder(int[][] matrix) {
      List<Integer> result = new ArrayList<>();

      if (matrix == null || matrix.length == 0) {
         return result;
      }
      // Right -> bottom -> left -> top
      int m = matrix.length; // rows
      int n = matrix[0].length; // cols

      int top = 0;
      int right = n - 1;
      int bottom = m - 1;
      int left = 0;

      while (top <= bottom && left <= right) { // Top row
         for (int i = left; i <= right; i++) {
            result.add(matrix[top][i]);
         }
         top++;
         // Right col
         for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
         }
         right--;
         // Bottom row
         if (top <= bottom) {
            for (int i = right; i >= left; i--) {
               result.add(matrix[bottom][i]);
            }
            bottom--;
         }

         // Left col
         if (left <= right) {
            for (int i = bottom; i >= top; i--) {
               result.add(matrix[i][left]);
            }
            left++;
         }
      }
      return result;

   }
}
