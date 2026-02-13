class Solution {
    class Pair{
        int node;
        double p;

        public Pair(int node, double p){
            this.node = node;
            this.p=p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double p = succProb[i];

            adj.get(u).add(new Pair(v,p));
            adj.get(v).add(new Pair(u,p));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.p , a.p));
        double[] probability = new double[n];
        Arrays.fill(probability, Integer.MIN_VALUE);
        pq.offer(new Pair(start_node,1));
        probability[start_node] = 1;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int u = curr.node;
            double prob = curr.p;

            for(Pair neigh : adj.get(u)){
                int v = neigh.node;
                double pathProbab = neigh.p;

                if(probability[v] < probability[u]*pathProbab){
                    probability[v] = probability[u] * pathProbab;
                    pq.offer(new Pair(v,probability[v]));
                }
            }

        }
       return ( probability[end_node] == Integer.MIN_VALUE) ? 0 : probability[end_node];
    }
}