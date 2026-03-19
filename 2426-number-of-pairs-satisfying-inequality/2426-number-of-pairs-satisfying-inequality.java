class Solution {
    static class SegTree{
        int n;
        int[] tree;
        public SegTree(int n){
            this.n = n;
            tree = new int[4*n];
        }
        public int query(int idx, int L, int R, long qs, int qe){
         // No overLap
            if(L>qe || R<qs){
                return 0;
            }
            // Fully Overlap
            if(qs<=L && R<=qe){
                return tree[idx];
            }
            // Partial
            int mid =  L+(R-L)/2;
            return query(2*idx+1, L,mid,qs,qe) + query(2*idx+2, mid+1, R, qs, qe);
        }

        public void update(int idx, int L , int R, int targ){// idx is node which we have to update
            if(L==R){
                tree[idx]++;
                return;
            }
            // Point update
            int mid = L+(R-L)/2;

            if(targ<=mid){
                update(2*idx+1,L,mid,targ);
            }else{
                update(2*idx+2, mid+1, R, targ);
            }
            tree[idx] = tree[2*idx+1] + tree[2*idx+2];
        }
    }
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        
        int n = nums1.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = nums1[i] - nums2[i];
        }

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<n;i++){
            set.add(ans[i]);
            set.add(ans[i] + diff);
        }
        List<Integer> list = new ArrayList<>(set);
        // compression
        int index =0 ;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<list.size();i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),index++);
            }
        }

        long count = 0;
        SegTree seg = new SegTree(index);

        for(int j=0;j<n;j++){
            int right = map.get(ans[j] + diff); // arr[i] <= arr[j]+diff(right)
            count += seg.query(0,0,index-1,0,right);
            seg.update(0,0,index-1,map.get(ans[j]));
        }
        return count;
    }
}