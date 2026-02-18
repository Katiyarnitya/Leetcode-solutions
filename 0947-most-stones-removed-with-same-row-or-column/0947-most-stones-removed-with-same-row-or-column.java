class Solution {
    static int component;
    public static int findParent(int x, int[] parent) {
      if (x == parent[x]) {
         return x;
      }
      return parent[x] = findParent(parent[x], parent);
    }

    public static boolean union(int x, int y, int[] parent, int[] rank) {
      int px = findParent(x, parent);
      int py = findParent(y, parent);
      if (px == py)
         return false;

      int rx = rank[px];
      int ry = rank[py];

      if (rx > ry) {
         parent[py] = px;
      } else if (rx < ry) {
         parent[px] = py;
      } else {
         parent[px] = py;
         rank[py]++;
      }
      return true;
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        component = n;

        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int[] rank = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    if(union(i,j,parent,rank)){
                        component--;
                    }
                }
            }
        }
        return n-component;
    }
}