class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n;i++){
        
            HashSet<Integer> set = new HashSet<>();
            for(int j=i+1; j<n;j++){
                
                int req = -nums[i] - nums[j];
                if(set.contains(req)){
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],req);
                    Collections.sort(triplet);
                    ans.add(triplet);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}