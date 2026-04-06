class Solution {
    int mod = 1_000_000_000 + 7;
    Integer[][][] dp;
    
    public int solve(int idx, int remaining, int currProfit, int minProfit, int[] group, int[] profit){
        if(idx==group.length){
            if(currProfit >=minProfit) return 1;
            return 0;
        }
        if(currProfit>= minProfit){
            currProfit = minProfit;
        }
        if(dp[idx][remaining][currProfit] != null) return dp[idx][remaining][currProfit];

        int notTake = solve(idx+1,remaining, currProfit,minProfit, group,profit);
        
        int take = 0;
        if(group[idx]<= remaining){
           take = solve(idx+1, remaining-group[idx], profit[idx] + currProfit,minProfit, group, profit);
        }
        return dp[idx][remaining][currProfit] = (take + notTake)% mod;
    }
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int size = group.length;
        dp = new Integer[size][n+1][101];

        return solve(0,n,0,minProfit,group,profit);
    }
}