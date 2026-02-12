class Solution {
    class Pair{
        int node;
        int t;
        public Pair(int node, int t){
            this.node = node;
            this.t = t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(v,time));
        }

        int[] time = new int[n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.t,b.t));
        pq.offer(new Pair(k,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int  u = curr.node;
            int t = curr.t;

            if(t> time[u]) continue;

            for(Pair neigh : adj.get(u)){
                int v = neigh.node;
                int timeUV = neigh.t;

                if(time[v] > time[u] + timeUV){
                    time[v] = time[u] + timeUV;
                    pq.offer(new Pair(v, time[v]));
                }
            }
        }

        int minTime = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(time[i] == Integer.MAX_VALUE){
                return  -1;
            }else{
                minTime = Math.max(minTime,time[i]);
            }
        }
        return minTime;
    }
}