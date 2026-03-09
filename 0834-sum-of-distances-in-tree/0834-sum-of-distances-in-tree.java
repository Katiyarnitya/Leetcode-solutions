class Solution {
    List<Integer>[] tree; // ArrayList for storing the tree
    static int[] distance;
    static int[] subTree;
    static int[] ans;
    int N;

    public void dfs(int node, int parent){ // It is calculating intial calculations for 0
        subTree[node] = 1;
        for(int child : tree[node]){
            if(child==parent) continue; //cycle
            dfs(child,node);
            subTree[node] += subTree[child];
            distance[node] += distance[child] + subTree[child]; 
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        
        N = n;
        tree = new ArrayList[n];
        distance = new int[n];
        subTree = new int[n];
        ans = new int[n];
        for(int i=0;i<n;i++){
            tree[i] = new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(0,-1);
        ans[0] = distance[0];

        reRoot(0,-1); //it will go to every node and will conside each node as root and then apply formula
        return ans;
    }

    public void reRoot(int node, int parent){

        for(int child : tree[node]){
            if(child==parent) continue;
            ans[child] = ans[node] + N-2*subTree[child];
            reRoot(child,node);
        }
    }
}