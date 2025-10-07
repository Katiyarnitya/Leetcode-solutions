class Solution {

   public boolean dfsCycleCheck(int node, int[] vis, int[] pathVis, int[][] graph, int[] check) {
      vis[node] = 1;
      pathVis[node] = 1;
      check[node] = 0; // Not safe

      for (int neigh : graph[node]) {
         // Cycle found conditions
         if (vis[neigh] == 0) {// if unvisited
            if (dfsCycleCheck(neigh, vis, pathVis, graph, check) == true) {
               check[node] = 0;
               return true;
            }
         } else if (pathVis[neigh] == 1) {// if node is visited and pathVisit of that node is also one means part of
                                          // same cycle
            check[node] = 0;
            return true;
         }
      }
      check[node] = 1;
      pathVis[node] = 0;
      return false;
   }

   public List<Integer> eventualSafeNodes(int[][] graph) {
      List<Integer> ans = new ArrayList<>();
      int[] vis = new int[graph.length];
      int[] pathVis = new int[graph.length];
      int[] check = new int[graph.length];// Check will have 0 and 1 indicating safe and unsafe nodes

      for (int i = 0; i < graph.length; i++) {
         if (vis[i] == 0) {
            dfsCycleCheck(i, vis, pathVis, graph, check);
         }
      }

      for (int i = 0; i < check.length; i++) {
         if (check[i] == 1) {
            ans.add(i);
         }
      }
      return ans;
   }
}