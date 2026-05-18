class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;


        int[] count = new int[n];
        Arrays.fill(count,1);

        for(int curr = 1; curr<n; curr++){
            for(int prev = 0; prev<=curr-1; prev++){
                if(nums[curr] > nums[prev] && dp[curr] < dp[prev] + 1){
                    dp[curr] = dp[prev] + 1;
                    count[curr] = count[prev];
                }else if(nums[curr] > nums[prev] && dp[curr] == dp[prev] + 1){
                    count[curr] += count[prev];
                }
                maxi = Math.max(maxi, dp[curr]);
            }
        }

        int numLIS = 0;
        for(int i=0;i<n;i++){
            if(dp[i] == maxi){
                numLIS += count[i];
            }
        }
    return numLIS;
    }
}