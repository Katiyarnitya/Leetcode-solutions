class Solution {
    class Tuple{
        int r;
        int c;
        int diff;
        public Tuple(int r, int c, int diff){
            this.r = r;
            this.c = c;
            this.diff = diff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;

        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b)-> Integer.compare(a.diff,b.diff));
        pq.offer(new Tuple(0,0,0));

        int[][] effort = new int[n][m];
        for(int[] row : effort){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        int minEffort = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Tuple curr = pq.poll();
            int r = curr.r;
            int c = curr.c;
            // int diff = curr.diff;

            if(r== n-1 && c==m-1){
                int eff = effort[r][c];
                minEffort = Math.min(minEffort,eff);
            }
            for(int i=0;i<4;i++){
                int newR = r + dr[i];
                int newC = c + dc[i];
                if(newR>=0 && newC>=0 && newR<n && newC< m){
                    int costNRNC = Math.abs(heights[r][c]-heights[newR][newC]);
                    if(effort[newR][newC] > Math.max(effort[r][c],costNRNC)){
                        effort[newR][newC] = Math.max(effort[r][c],costNRNC);
                        pq.offer(new Tuple(newR, newC, effort[newR][newC]));
                    }
                }
            }
        }
        return minEffort;
    }
}

// class Tuple{
//     int diff;
//     int row;
//     int col;
//     Tuple(int diff,int row, int col){
//         this.diff = diff;
//         this.row = row;
//         this.col = col;
//     }
// }
// class Solution {
//     public int minimumEffortPath(int[][] heights) {
//         int rows = heights.length;
//         int cols = heights[0].length;

//         int[][] dist = new int[rows][cols];
//         for(int i=0;i<rows;i++){
//             Arrays.fill(dist[i],Integer.MAX_VALUE);
//         }
//         dist[0][0]=0;// Min. diff with it's adj cell will be 0
//         PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> a.diff - b.diff);
//         pq.add(new Tuple(0,0,0));

//         int[] delRow = {-1,0,+1,0};
//         int[] delCol = {0,+1,0,-1};

//         while(!pq.isEmpty()){
//             Tuple it = pq.poll();
//             int diff = it.diff;
//             int row = it.row;
//             int col = it.col;

//             if(row == rows-1 && col == cols-1){
//                 return diff;
//             }

//             for(int i=0;i<4;i++){
//                 int newR = row + delRow[i];
//                 int newC = col + delCol[i];

//                 if((newR >= 0 && newR < rows) && (newC >= 0 && newC < cols)){
//                     int newEffort = Math.max(Math.abs(heights[row][col]-heights[newR][newC]),diff);//cCalculating path's maximum
//                     if(newEffort<dist[newR][newC]){
//                         dist[newR][newC] = newEffort;
//                         pq.add(new Tuple(newEffort,newR,newC));
//                     }
//                 }

//             }

//         }
//         return -1;
//     }
// }