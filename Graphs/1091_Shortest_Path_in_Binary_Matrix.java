class Tuple {
   int dis;
   int row;
   int col;

   Tuple(int dis, int row, int col) {
      this.dis = dis;
      this.row = row;
      this.col = col;
   }
}

class Solution {
   public int shortestPathBinaryMatrix(int[][] grid) {
      int n = grid.length;
      if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
         return -1;// If intially it is blocked

      int[][] dist = new int[n][n];
      for (int[] row : dist)
         Arrays.fill(row, Integer.MAX_VALUE);

      dist[0][0] = 1;

      int[] delRow = { -1, -1, -1, 0, 0, 1, 1, 1 };
      int[] delCol = { -1, 0, 1, -1, 1, -1, 0, 1 };

      Queue<Tuple> q = new LinkedList<>();
      q.add(new Tuple(1, 0, 0));

      while (!q.isEmpty()) {
         Tuple it = q.poll();
         int dis = it.dis;
         int row = it.row;
         int col = it.col;

         if (row == n - 1 && col == n - 1) {
            return dist[row][col];
         }

         for (int i = 0; i < 8; i++) {
            int newR = row + delRow[i];
            int newC = col + delCol[i];

            int newDis = dis + 1;
            if ((newR >= 0 && newR < n) && (newC >= 0 && newC < n) && (grid[newR][newC] == 0)
                  && (newDis < dist[newR][newC])) {
               dist[newR][newC] = newDis;
               q.add(new Tuple(newDis, newR, newC));
            }
         }

      }

      return -1;
   }
}