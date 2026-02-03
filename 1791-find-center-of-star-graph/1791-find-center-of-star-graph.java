class Solution {
    public int findCenter(int[][] edges) {
        int V = edges.length+1;
        int e= edges.length;

        // int[][] matrix = new int[V+1][V+1];
        // for(int i=0;i<e;i++){
        //     matrix[edges[i][0]][edges[i][1]] = 1;
        //     matrix[edges[i][1]][edges[i][0]] = 1;
        // }
        // for(int i=0;i<=V;i++){
        //     int count=0;
        //     for(int j=0;j<=V; j++){
        //         if(matrix[i][j] ==1){
        //             count++;
        //         }
        //     }
        //     if(count==e){
        //         return i;
        //     }
        // }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<e;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

        }
        for(int i=0;i<=V;i++){
            if(adj.get(i).size()== e){
                    return i;
            }
        }
        return -1;
    }
}