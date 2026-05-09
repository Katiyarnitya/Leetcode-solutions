class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indeg = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indeg[prerequisites[i][0]]++;
        }        

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int c = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            c++;

            for(int neigh : adj.get(node)){
                indeg[neigh]--;
                if(indeg[neigh]==0){
                    q.offer(neigh);
                }
            }
        }
        return c==numCourses;
    }
}
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int i = 0; i < prerequisites.length; i++) {
//             adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // prereq → course
//         }

//         int[] inDegree = new int[numCourses];
//         for (int i = 0; i < numCourses; i++) {
//             for (int neigh : adj.get(i)) {
//                 inDegree[neigh]++;
//             }
//         }

//         Queue<Integer> Q = new LinkedList<>();
//         List<Integer> list = new ArrayList<>();

//         for (int i = 0; i < numCourses; i++) {
//             if (inDegree[i] == 0) {
//                 Q.add(i);
//             }
//         }

//         while (!Q.isEmpty()) {
//             int node = Q.poll();
//             list.add(node);
//             for (int neigh : adj.get(node)) {
//                 inDegree[neigh]--;
//                 if (inDegree[neigh] == 0) {
//                     Q.add(neigh);
//                 }
//             }
//         }
//         return (list.size() == numCourses);
//     }
// }
