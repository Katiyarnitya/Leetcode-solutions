class Solution {
    public void BFS(List<List<Integer>> rooms, boolean[] visited){
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()){
            int node = q.poll();
            for(int neigh : rooms.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for(int i=0;i<rooms.size();i++){
        //     adj.add(new ArrayList<>());
        // }
        // for(int i=0;i<rooms.size();i++){
        //    for (int key : rooms.get(i)) {
        //         adj.get(i).add(key);
        //     }
        // }
        boolean[] visited = new boolean[rooms.size()];
        BFS(rooms,visited);

        boolean flag = true;
        for(int i=0;i<visited.length;i++){
            if(visited[i] == false){
                flag = false;
            }
        }
        return flag;
    }
}