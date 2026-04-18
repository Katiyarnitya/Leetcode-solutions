class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int ele : graph[i]){
                adj.get(i).add(ele);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][1<<n]; // this 2^n

        for(int i=0;i<n;i++){
            int mask = 1<<i;
            q.offer(new int[]{i,mask});
            visited[i][mask] = true;
        }

        int pathLength = 0;
        int finalMask = (1<<n) - 1; // this always gives 1111...

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                int node = curr[0];
                int mask = curr[1];

                if(mask==finalMask){
                    return pathLength;
                }

                for(int neigh : adj.get(node)){
                    int newMask = ((1<<neigh) | mask);

                    if(!visited[neigh][newMask]){
                        visited[neigh][newMask] = true;
                        q.offer(new int[]{neigh, newMask});
                    }
                }
            }
            pathLength++;
        }
        return -1;
    }
}