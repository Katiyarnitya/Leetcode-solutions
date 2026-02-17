class Solution {
    static int comp;
    public int findParent(int x, int[] parent){
        if(x==parent[x]) return x;
        return parent[x]= findParent(parent[x], parent);
    }
    public boolean union(int x, int y, int[] parent, int[] rank){
        int p_x = findParent(x,parent);
        int p_y = findParent(y,parent);
        if(p_x==p_y) return false;

        if(rank[p_x]>rank[p_y]){
            parent[p_y] = p_x;
        }else if(rank[p_x]<rank[p_y]){
            parent[p_x] = p_y;
        }else{
            parent[p_x] = p_y;
            rank[p_y]++;
        }
        comp--;
        return true;
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        comp = n;
       int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int[] rank = new int[n];


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j || i>j){
                    continue;
                }else{
                   if(isConnected[i][j] == 1){
                        union(i, j, parent, rank);
                    }
                }
            }
        }
        return comp;
    }
}

// class Solution {
//     public void dfs(ArrayList<ArrayList<Integer>> adjLs,boolean[] visited, int node){
//         visited[node]=true;
//         for(int neigh : adjLs.get(node)){
//             if(!visited[neigh]){
//                 visited[neigh]=true;
//                 dfs(adjLs,visited,neigh);
//             }
//         }
//     }
//     public int findCircleNum(int[][] isConnected) {

//         // Converting matrix -> list
//         ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
//         for(int i=0;i<isConnected.length;i++){
//                 adjLs.add(new ArrayList<Integer>());
//         }
//         for(int i=0;i<isConnected.length;i++){
//             for(int j =0;j<isConnected.length;j++){
//                 if(isConnected[i][j]==1 && i!=j){
//                     adjLs.get(i).add(j);
//                     adjLs.get(j).add(i);
//                 }
//             }
//         }

//         boolean[] visited = new boolean[isConnected.length];
//         int count=0;
//         for(int i=0;i<visited.length;i++){
//             if(!visited[i]){
//                 count++;
//                 dfs(adjLs,visited,i);
//             }
//         }
//         return count;
//     }
// }