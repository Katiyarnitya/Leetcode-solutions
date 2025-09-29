class Solution {
   public void reverse(int[] arr) {

      int n = arr.length;
      int l = 0;
      int r = n - 1;

      while (l < r) {
         int temp = arr[l];
         arr[l] = arr[r];
         arr[r] = temp;
         l++;
         r--;
      }
   }

   public void rotate(int[][] matrix) {

      int n = matrix[0].length;

      for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
            // Swap matrix[i][j] with matrix[j][i]
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
         }
      }
      for (int i = 0; i < n; i++) {
         reverse(matrix[i]);
      }
   }
}