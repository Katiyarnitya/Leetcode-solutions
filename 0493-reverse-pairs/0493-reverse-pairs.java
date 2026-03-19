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
    public int reversePairs(int[] nums) {
        
        int n = nums.length;
        HashSet<Long> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]*1L);
            set.add(nums[i]*2L);
        }
        List<Long> list = new ArrayList<>(set);
        Collections.sort(list);

        HashMap<Long, Integer> map = new HashMap<>();

        int idx = 0;
        for(long val : list){
            if(!map.containsKey(val)){
                map.put(val,idx++);
            }
        }

        SegTree seg = new SegTree(idx);
        int ans = 0;
        for(int j=0;j<n;j++){
            // arr[i] > arr[j] *2
            int val = map.get((long)nums[j]*2L);
            ans += seg.query(0,0,idx-1, val+1L, idx-1);
            seg.update(0,0,idx-1,map.get((long)nums[j]));
        }
        return ans;
    }
}