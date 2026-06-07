class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();


        for(int i=0;i<n;i++){
            long x = nums[i];

            for(int j=i+1;j<n;j++){
                long y = nums[j];

                HashSet<Long> set = new HashSet<>();

                for(int k=j+1;k<n;k++){

                    long required = (long)target- x - y - nums[k];
                    if(set.contains(required)){
                        List<Integer> quad = Arrays.asList((int)x,(int)y,(int)nums[k],(int)required);
                        Collections.sort(quad);
                        ans.add(quad);
                    }
                    set.add((long)nums[k]);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}