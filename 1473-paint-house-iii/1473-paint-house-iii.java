class Solution {
    static Integer[][][] dp;
    static int M;
    static int N;
    public static int solve(int idx, int prevColor, int neighs, int[] houses, int[][] cost, int target){

        if(idx==M){
            if(neighs == target) return 0;
            return (int)1e9;
        }
        if(neighs>target) return (int) 1e9;

        if(dp[idx][prevColor][neighs] != null) return dp[idx][prevColor][neighs];
        int ans  = (int) 1e9;
        if(houses[idx] !=0){
            int color = houses[idx];
            if(color!=prevColor){
               ans =  solve(idx+1, color, neighs+1, houses, cost, target);
            }else{
                ans = solve(idx+1, color, neighs, houses, cost, target);
            }
        }else{
            for(int i=1;i<=N;i++){
                ans = Math.min(ans, cost[idx][i-1] + solve(idx+1,i, (i!=prevColor) ? neighs+1 : neighs, houses, cost,target));
            }
        }
        return dp[idx][prevColor][neighs] = ans;
    }
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        M = m;
        N = n;
        dp = new Integer[m][n+1][target+1];

        int ans = solve(0,0,0,houses, cost, target);
        return (ans == (int)1e9) ? -1 : ans;
    }
}