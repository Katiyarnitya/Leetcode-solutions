class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        int maxi=1;
        int lastIdx = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);


        Arrays.sort(nums);

        for(int curr=0; curr<n; curr++){
            for(int prev = 0; prev<curr; prev++){
                if(nums[curr] % nums[prev] ==0 && dp[curr] < dp[prev] + 1){
                    dp[curr] = dp[prev]+1;
                    parent[curr] = prev;
                }
            }
            if(maxi<dp[curr]){
                maxi = dp[curr];
                lastIdx = curr;
            }
        }

        for(int i= lastIdx; i!=-1; i=parent[i]){
            ans.add(nums[i]);
        }
        Collections.reverse(ans);
        return ans;
    }
}