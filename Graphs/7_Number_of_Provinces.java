class Solution {
   public void dfs(ArrayList<ArrayList<Integer>> adjLs, boolean[] visited, int node) {
      visited[node] = true;
      for (int neigh : adjLs.get(node)) {
         if (!visited[neigh]) {
            visited[neigh] = true;
            dfs(adjLs, visited, neigh);
         }
      }
   }

   public int findCircleNum(int[][] isConnected) {

      // Converting matrix -> list
      ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
      for (int i = 0; i < isConnected.length; i++) {
         adjLs.add(new ArrayList<Integer>());
      }
      for (int i = 0; i < isConnected.length; i++) {
         for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && i != j) {
               adjLs.get(i).add(j);
               adjLs.get(j).add(i);
            }
         }
      }

      boolean[] visited = new boolean[isConnected.length];
      int count = 0;
      for (int i = 0; i < visited.length; i++) {
         if (!visited[i]) {
            count++;
            dfs(adjLs, visited, i);
         }
      }
      return count;
   }
}