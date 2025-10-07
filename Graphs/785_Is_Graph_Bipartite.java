class Solution {
   public boolean isBipartite(int[][] graph) {
      int n = graph.length;
      int[] color = new int[n];// 0-unoloured , 1-> color A, -1-> color B

      for (int i = 0; i < n; i++) {
         if (color[i] != 0) {
            continue;
         }

         Queue<Integer> Q = new LinkedList<>();
         Q.add(i);
         color[i] = 1;

         while (!Q.isEmpty()) {
            int node = Q.poll();
            for (int neigh : graph[node]) {
               if (color[neigh] == 0) { // If not coloured
                  Q.add(neigh);
                  color[neigh] = -color[node];
               } else if (color[neigh] == color[node]) {// color of curr node and its adj is same
                  return false;
               }
            }

         }
      }
      return true;
   }
}