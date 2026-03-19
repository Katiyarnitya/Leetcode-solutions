class Solution {
    static int[] st;

    static class SegTree{
        int n;
        int[] tree;
        public SegTree(int n){
            this.n = n;
            tree = new int[4*n];
        }

        public int query(int idx, int L, int R, int qs, int qe){

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
    public List<Integer> countSmaller(int[] nums) {
        
        int  n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>(); // can be long , integer if we are storing sum

        int index = 0;
        for(int val : sorted){
            if(!map.containsKey(val)){
                map.put(val,index++);
            }
        }
        // To create segtree craete the object of the class;

        SegTree seg = new SegTree(index);
        Integer[] ans = new Integer[n];

        // Right-> Left

        for(int i=n-1; i>=0;i--){
            int val  = map.get(nums[i]);
            ans[i] = seg.query(0,0,index-1,0,val-1);
            seg.update(0,0,index-1,val);
        }        
        return Arrays.asList(ans);
    }
}