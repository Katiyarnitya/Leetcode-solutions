class Solution {
    static int component;
    public static int findParent(int x, int[] parent) {
      if (x == parent[x]) {
         return x;
      }
      return parent[x] = findParent(parent[x], parent);
    }

    public static boolean union(int x, int y, int[] parent, int[] rank) {
      int px = findParent(x, parent);
      int py = findParent(y, parent);
      if (px == py)
         return false;

      int rx = rank[px];
      int ry = rank[py];

      if (rx > ry) {
         parent[py] = px;
      } else if (rx < ry) {
         parent[px] = py;
      } else {
         parent[px] = py;
         rank[py]++;
      }
      return true;
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, Integer> emailToId  = new HashMap<>(); // asociating each unique email with an id
        HashMap<String, String> emailToName  = new HashMap<>(); // asociating each email with an name

        int id=0;
        for(List<String> acc : accounts){
            String name = acc.get(0);

            for(int i=1;i<acc.size();i++){
                String email = acc.get(i);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email,id++);
                }
                emailToName.put(email,name);
            }
        }

        component = id;
        int parent[] = new int[id];
        for(int i=0;i<id;i++){
            parent[i] = i;
        }
        int rank[] = new int[id];

        for(List<String> acc : accounts){
            if(acc.size() <=2 ) continue;

            int firstAccountId = emailToId.get(acc.get(1));

            for(int k=2; k<acc.size();k++){ //  comparing 1st account mal to other mails
                union(firstAccountId, emailToId.get(acc.get(k)),parent,rank);
            }
        }
       HashMap<Integer, ArrayList<String>> groupToId = new HashMap<>();

       for(String email : emailToId.keySet()){
        int EmailId = emailToId.get(email);
            int root  = findParent(EmailId,parent);
            if(!groupToId.containsKey(root))
            {
                groupToId.put(root,new ArrayList<>());
            }
            groupToId.get(root).add(email);
       }

        List<List<String>> result = new ArrayList<>();

        for (int node : groupToId.keySet()) {
            List<String> merge = groupToId.get(node);
            Collections.sort(merge);
            List<String> ans = new ArrayList<>();
            ans.add(emailToName.get(merge.get(0)));
            ans.addAll(merge);
            result.add(ans);
        }     
        return result;
    }
}