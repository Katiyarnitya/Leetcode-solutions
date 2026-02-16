class Solution {
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
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.wt, b.wt));
        pq.offer(new Pair(0,0,0));

        int[][] obstacle = new int[m][n];
        for(int[] r : obstacle){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        obstacle[0][0] = 0;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            int wt = curr.wt;

            for(int i=0;i<4;i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                
                if(newR>=0 && newC>=0 && newR<m && newC<n ){
                    int newWt = (grid[newR][newC] == 1) ? 1 : 0;
                    if(obstacle[newR][newC] > obstacle[r][c] + newWt){
                        obstacle[newR][newC] = obstacle[r][c] + newWt;
                        pq.offer(new Pair(newR,newC,obstacle[newR][newC]));
                    }
                }
            }
        }
        return obstacle[m-1][n-1];
    }
}