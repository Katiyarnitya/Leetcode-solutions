class Solution {
    public int findCenter(int[][] edges) {

        int n = edges.length;
        int[] deg = new int[n+2];

        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            deg[u]++;
            deg[v]++;
        }
        for(int i=1;i<=n+1;i++){
            if(deg[i]==n){
                return i;
            }
        }
        return -1;
    }
}