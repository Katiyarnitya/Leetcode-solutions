class Solution {
     class Pair{
        int node;
        long dis;
        public Pair(int node, long dis){
            this.node = node;
            this.dis = dis;
        }
    }
    static int MOD = (int)1e9 + 7;

    public int countPaths(int n, int[][] roads) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<roads.length;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int dis = roads[i][2];
            adj.get(u).add(new Pair(v,dis));
            adj.get(v).add(new Pair(u,dis));

        }

        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        distance[0] = 0;
        long[] ways = new long[n];
        ways[0]=1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dis,b.dis));
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int  u = curr.node;
            long d = curr.dis;

            if(d> distance[u]) continue;

            for(Pair neigh : adj.get(u)){
                int v = neigh.node;
                long costUV = neigh.dis;

                if(distance[v] == distance[u] + costUV){
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
                if(distance[v] > distance[u] + costUV){
                    distance[v] = distance[u] + costUV;
                    ways[v]=ways[u];
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }
        return (int)ways[n-1];
    }
} 
// class Pair{
//     long  dis;  
//     int node;
//     Pair(long dis, int node){
//         this.dis=dis;
//         this.node=node;
//     }
// }
// class Solution {
//     public int countPaths(int n, int[][] roads) {

//         int mod = (int)(1e9+7);

//         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int[] it : roads){
//             int u = it[0];
//             int v = it[1];
//             int dis = it[2];

//             adj.get(u).add(new Pair(dis,v));
//             adj.get(v).add(new Pair(dis,u));
//         }

//         long[] dist = new long[n];
//         Arrays.fill(dist, Long.MAX_VALUE);
//         dist[0] = 0;

//         int[] ways = new int[n];
//         ways[0]=1;

//         PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
//         pq.add(new Pair(0L, 0));

//         while(!pq.isEmpty()){
//             Pair it = pq.poll();
//             long dis = it.dis;
//             int node = it.node;

//             for(Pair neigh : adj.get(node)){
//                 int  adjNode = neigh.node;
//                 long adjDis = neigh.dis;
//                 // This is the first time we are comming with this shortest distance
//                 if(dis+adjDis < dist[adjNode]){
//                     dist[adjNode] = dis+adjDis;
//                     pq.add(new Pair(dis+adjDis,adjNode));
//                     ways[adjNode] = ways[node];
//                 }else if(dis+adjDis == dist[adjNode]){// We found another path with same shorter dist
//                     ways[adjNode] = (int)(((long)ways[adjNode] + ways[node]) % mod);
//                 }
//             }
//         }
//         return ways[n-1];
//     }
// }