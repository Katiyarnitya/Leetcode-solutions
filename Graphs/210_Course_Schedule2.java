class Solution {
   public int[] findOrder(int numCourses, int[][] prerequisites) {

      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

      for (int i = 0; i < numCourses; i++) {
         adj.add(new ArrayList<>());
      }
      for (int i = 0; i < prerequisites.length; i++) {
         adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // prereq → course
      }
      int[] inDegree = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
         for (int neigh : adj.get(i)) {
            inDegree[neigh]++;
         }
      }
      Queue<Integer> Q = new LinkedList<>();
      int[] order = new int[numCourses];
      int idx = 0;

      for (int i = 0; i < numCourses; i++) {
         if (inDegree[i] == 0) {
            Q.add(i);
         }
      }
      while (!Q.isEmpty()) {
         int node = Q.poll();
         order[idx++] = node;
         for (int neigh : adj.get(node)) {
            inDegree[neigh]--;
            if (inDegree[neigh] == 0) {
               Q.add(neigh);
            }
         }
      }
      if (idx != numCourses)
         return new int[0];
      return order;
   }
}