class Tuple {
   int stop;
   int node;
   int cost;

   Tuple(int stop, int node, int cost) {
      this.stop = stop;
      this.node = node;
      this.cost = cost;
   }
}

class Pair {
   int first;
   int sec;

   Pair(int first, int sec) {
      this.first = first;
      this.sec = sec;
   }
}

class Solution {
   public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

      ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
         adj.add(new ArrayList<>());
      }
      for (int[] edge : flights) {
         int u = edge[0];
         int v = edge[1];
         int cost = edge[2];
         adj.get(u).add(new Pair(v, cost)); // As flights are not bidirectional
      }

      int[] dist = new int[n];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[src] = 0;

      Queue<Tuple> q = new LinkedList<>();
      q.add(new Tuple(0, src, 0));

      while (!q.isEmpty()) {
         Tuple it = q.poll();
         int stop = it.stop;
         int node = it.node;
         int cost = it.cost;

         if (stop > k)
            continue;// Do not explore further neighbours
         for (Pair neigh : adj.get(node)) {
            int adjNode = neigh.first;
            int adjCost = neigh.sec;

            if (adjCost + cost < dist[adjNode] && stop <= k) {
               dist[adjNode] = adjCost + cost;
               q.add(new Tuple(stop + 1, adjNode, adjCost + cost));
            }
         }
      }
      return (dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst]);
   }
}