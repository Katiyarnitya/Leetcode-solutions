class Solution {
    int n;
    public int solve(int idx, int k, int[] arr, int[] dp){
        if(idx==n) return 0;
        if(dp[idx] != -1)return dp[idx];
        int len=0;
        int maxiEle = Integer.MIN_VALUE;
        int maxSubarrayCost = Integer.MIN_VALUE;
        for(int i=idx; i< Math.min(n,idx+k); i++){
            len++;
            maxiEle = Math.max(arr[i],maxiEle);// Finding the max element of subarray
            int cost = maxiEle * len + solve(i+1,k,arr,dp);
            maxSubarrayCost = Math.max(maxSubarrayCost,cost);// This is finding global out of all the k costs calculated 
        }
        return dp[idx] = maxSubarrayCost;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;

        // Arrays.fill(dp,-1);

        int[] dp = new int[n+1];
        // n+1 tabulation because when i=n-1 it calls

        for(int i=n-1; i>=0;i--){
            int len=0;
            int maxiEle = Integer.MIN_VALUE;
            int maxSubarrayCost = Integer.MIN_VALUE;
            for(int j=i; j< Math.min(n,i+k); j++){
                len++;
                maxiEle = Math.max(arr[j],maxiEle);
                int cost = maxiEle * len + dp[j+1];
                maxSubarrayCost = Math.max(maxSubarrayCost,cost);
            }
            dp[i] = maxSubarrayCost; 
        }
        return dp[0];
        // return solve(0,k,arr, dp);
    }
}