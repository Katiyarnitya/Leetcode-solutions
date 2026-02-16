class Solution {
    class Pair{
        int r;
        int c;
        int step;
        int k;
        public Pair(int r, int c, int step, int k){
            this.r = r;
            this.c = c;
            this.step = step;
            this.k = k;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.step, b.step));
        pq.offer(new Pair(0,0,0,k));

        boolean[][][] visited = new boolean[m][n][k+1];
        visited[0][0][k] = true;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int step = curr.step;
            int myk = curr.k;
            if(r==m-1 && c==n-1){
                return step;
            }
            for(int i=0;i<4;i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                
                if(newR>=0 && newC>=0 && newR<m && newC<n ){
                    int newk = (grid[newR][newC] == 1) ? myk-1 : myk;
                    if(newk>=0 && !visited[newR][newC][newk]){
                        visited[newR][newC][newk] = true;
                        pq.offer(new Pair(newR,newC,step+1,newk));
                    }
                }
            }
        }
        return -1;
    }
}