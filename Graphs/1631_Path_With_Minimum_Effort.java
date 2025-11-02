class Tuple {
   int diff;
   int row;
   int col;

   Tuple(int diff, int row, int col) {
      this.diff = diff;
      this.row = row;
      this.col = col;
   }
}

class Solution {
   public int minimumEffortPath(int[][] heights) {
      int rows = heights.length;
      int cols = heights[0].length;

      int[][] dist = new int[rows][cols];
      for (int i = 0; i < rows; i++) {
         Arrays.fill(dist[i], Integer.MAX_VALUE);
      }
      dist[0][0] = 0;// Min. diff with it's adj cell will be 0
      PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
      pq.add(new Tuple(0, 0, 0));

      int[] delRow = { -1, 0, +1, 0 };
      int[] delCol = { 0, +1, 0, -1 };

      while (!pq.isEmpty()) {
         Tuple it = pq.poll();
         int diff = it.diff;
         int row = it.row;
         int col = it.col;

         if (row == rows - 1 && col == cols - 1) {
            return diff;
         }

         for (int i = 0; i < 4; i++) {
            int newR = row + delRow[i];
            int newC = col + delCol[i];

            if ((newR >= 0 && newR < rows) && (newC >= 0 && newC < cols)) {
               int newEffort = Math.max(Math.abs(heights[row][col] - heights[newR][newC]), diff);// cCalculating path's
                                                                                                 // maximum
               if (newEffort < dist[newR][newC]) {
                  dist[newR][newC] = newEffort;
                  pq.add(new Tuple(newEffort, newR, newC));
               }
            }

         }

      }
      return -1;
   }
}