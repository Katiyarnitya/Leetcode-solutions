class Solution {
    public static int solve(int idx, int[] coins, int amount, Integer[][] dp){
        if(amount == 0){
            return 0;
        }
        if(idx == coins.length-1){
            if(amount % coins[coins.length-1] == 0){
                return amount/coins[coins.length-1];
            }else{
                return (int) 1e9;
            }
        }
        if(dp[idx][amount] !=null) return dp[idx][amount];
        int pick = (int) 1e9;
        if(amount>=coins[idx]){
            pick = 1 + solve(idx, coins, amount-coins[idx], dp);
        }
        int notpick = 0 + solve(idx+1,coins,amount,dp);
        return dp[idx][amount] = Math.min(pick,notpick); 
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount +1];
        int ans =  solve(0,coins,amount,dp);
        return (ans >=(int) 1e9) ? -1 : ans;
    }
}

// class Solution {

//     public int coinChange(int[] coins, int amount) {

//         int n = coins.length;
//         Integer[][] dp = new Integer[n][amount+1];
//         for(int t=0;t<=amount; t++){
//             dp[0][t] = (t%coins[0] == 0) ? t/coins[0] : (int)1e9;
//         }
//         for(int i=1; i<n;i++){
//             for(int t=0 ;t<=amount;t++){
//                 int notTake = dp[i-1][t];
//                 int take = Integer.MAX_VALUE;
//                 if(coins[i]<=t){
//                     take = 1+dp[i][t-coins[i]];
//                 }
//                 dp[i][t] = Math.min(take,notTake);
//             }
//         }
//         int ans = dp[n-1][amount];
//         return (ans >= (int)1e9) ? -1 : ans;

//     }
//     // public int solveRec(int idx, int targ, int[] coins, Integer[][] dp){
//     //     if(targ == 0) return 0;
//     //     if(idx==0){
//     //         if( targ % coins[0] == 0){
//     //             return targ/coins[0];
//     //         }else{
//     //             return (int)1e9;
//     //         }
//     //     }
//     //     if(dp[idx][targ] != null) return dp[idx][targ];

//     //     int notTake = solveRec(idx-1, targ, coins,dp);
//     //     int take = (int)1e9;
//     //     if(coins[idx] <= targ){
//     //         take = 1 + solveRec(idx, targ-coins[idx], coins, dp);
//     //     }
//     //     return dp[idx][targ] =  Math.min(take,notTake);
//     // }

// }