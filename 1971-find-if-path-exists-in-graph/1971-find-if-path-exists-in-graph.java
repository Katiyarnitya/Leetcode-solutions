class Solution {
    public void BFS(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        visited[src] = true;
        q.offer(src);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        BFS(adj,source,visited);

        return visited[destination];
    }
}