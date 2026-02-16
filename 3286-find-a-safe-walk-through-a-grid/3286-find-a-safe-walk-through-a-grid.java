class Solution {
    static int[] dr = { 0,0,-1,1};
    static int[] dc = {-1,1,0,0};
    static int m;
    static int n;

        class Pair{
        int r;
        int c;
        int wt;
        public Pair(int r, int c, int wt){
            this.r = r;
            this.c = c;
            this.wt = wt;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        if(grid.get(0).get(0) == 1){
            health-=1;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.wt, a.wt));
        pq.offer(new Pair(0,0,health));

        boolean[][] vis = new boolean[m][n];
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int hlth = curr.wt;
            
            if(r==m-1 && c==n-1 && hlth>0) return true;

            for(int i=0;i<4;i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                
                
                if(newR>=0 && newC>=0 && newR<m && newC<n ){
                    if(grid.get(newR).get(newC) == 1 && !vis[newR][newC]){
                        vis[newR][newC] = true;
                        pq.offer(new Pair(newR,newC,hlth-1));
                    }else if(grid.get(newR).get(newC) == 0 && !vis[newR][newC]){
                        vis[newR][newC] = true;
                        pq.offer(new Pair(newR,newC,hlth));
                    }
                }
            }
        }
        return false;
    }
}

// class Solution {
//     static int[] dr = { 0,0,-1,1};
//     static int[] dc = {-1,1,0,0};
//     static int m;
//     static int n;
//     public boolean dfs(int r, int c, List<List<Integer>> grid, boolean[][] visited , int health){
//         visited[r][c] = true;

//         if(health<=0 && r !=m-1 && c!=n-1){
//             return false;
//         }
//         if(health>0 && r ==m-1 && c==n-1){
//             return true;
//         }
//         boolean possible = true;
//         for(int i=0;i<4;i++){
//             int newR = r + dr[i];
//             int newC = c + dc[i];

//             if(newR>=0 && newC>=0 && newR<m && newC<n && !visited[r][c]){
//                 if(grid.get(newR).get(newC) == 1){
//                     possible = possible || dfs(newR, newC, grid, visited, health-1);
//                 }else{
//                     possible = possible || dfs(newR,newC,grid,visited,health);
//                 }
//             }
//         }
//         return possible;
//     }
//     public boolean findSafeWalk(List<List<Integer>> grid, int health) {
//         m = grid.size();
//         n = grid.get(0).size();

//         boolean[][] visited = new boolean[m][n];

//         boolean ans = false;
//         if(grid.get(0).get(0) == 1){
//            ans =  dfs(0,0,grid,visited,health-1);
//         }else{
//             ans = dfs(0,0,grid,visited,health);
//         }
//         return ans;
//     }
// }