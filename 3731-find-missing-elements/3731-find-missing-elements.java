class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        int n = nums.length;
        int mini = 100;
        int maxi = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
            mini = Math.min(mini,nums[i]);
            maxi = Math.max(maxi,nums[i]);
        }
        
        List<Integer> ans = new ArrayList<>();

        if(maxi-mini+1 == n){
            return ans;
        }else{
            for(int i=mini+1; i<maxi; i++){
                if(!set.contains(i)){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}