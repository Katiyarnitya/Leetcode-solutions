class Pair {
   long dis;
   int node;

   Pair(long dis, int node) {
      this.dis = dis;
      this.node = node;
   }
}

class Solution {
   public int countPaths(int n, int[][] roads) {

      int mod = (int) (1e9 + 7);

      ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         adj.add(new ArrayList<>());
      }

      for (int[] it : roads) {
         int u = it[0];
         int v = it[1];
         int dis = it[2];

         adj.get(u).add(new Pair(dis, v));
         adj.get(v).add(new Pair(dis, u));
      }

      long[] dist = new long[n];
      Arrays.fill(dist, Long.MAX_VALUE);
      dist[0] = 0;

      int[] ways = new int[n];
      ways[0] = 1;

      PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dis, b.dis));
      pq.add(new Pair(0L, 0));

      while (!pq.isEmpty()) {
         Pair it = pq.poll();
         long dis = it.dis;
         int node = it.node;

         for (Pair neigh : adj.get(node)) {
            int adjNode = neigh.node;
            long adjDis = neigh.dis;
            // This is the first time we are comming with this shortest distance
            if (dis + adjDis < dist[adjNode]) {
               dist[adjNode] = dis + adjDis;
               pq.add(new Pair(dis + adjDis, adjNode));
               ways[adjNode] = ways[node];
            } else if (dis + adjDis == dist[adjNode]) {// We found another path with same shorter dist
               ways[adjNode] = (int) (((long) ways[adjNode] + ways[node]) % mod);
            }
         }
      }
      return ways[n - 1];
   }
}