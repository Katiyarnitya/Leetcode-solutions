class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare((a[0]*a[0] + a[1]*a[1]), (b[0]*b[0] + b[1]*b[1])));
        for(int i=0;i<n;i++){
            pq.offer(points[i]);
        }

        int[][] answer = new int[k][2];
        while(k>0 && !pq.isEmpty()){
            answer[k-1] = pq.poll();
            k--;
        }
        return answer;
    }
}