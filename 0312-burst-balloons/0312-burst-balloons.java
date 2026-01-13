class Solution {
    Integer[][] dp;
    public int solve(int i, int j, int[]arr, Integer[][]dp){
        if(i>j) return 0;

        if(dp[i][j] != null)return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for(int idx=i; idx<=j; idx++){
            int cost = arr[i-1] * arr[idx] * arr[j+1] + solve(i,idx-1,arr,dp) + solve(idx+1,j,arr,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[n+2];
        newNum[0]=1;
        newNum[newNum.length-1]=1;
        for(int i=1;i<=n;i++){
            newNum[i] = nums[i-1];
        } 
       dp = new Integer[n+1][n+1];
       return solve(1, n, newNum, dp);

    }
}