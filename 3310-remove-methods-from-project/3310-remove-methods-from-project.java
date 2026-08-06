class Solution {

    public void dfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[src] = true;

        for(int neigh : adj.get(src)){
            if(!vis[neigh]){
                dfs(neigh,vis,adj);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<invocations.length;i++){
            int a = invocations[i][0];
            int b = invocations[i][1];
            adj.get(a).add(b);
        }

        boolean[] vis = new boolean[n];
        dfs(k,vis,adj);

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ArrayList<Integer> list = adj.get(i);
                for(int j=0; j<list.size(); j++){
                    if(vis[list.get(j)]){
                        for(int num = 0;num<n;num++){
                            ans.add(num);
                        }
                        return ans;
                    }else{
                        continue;
                    }
               } 
            }
        }
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}