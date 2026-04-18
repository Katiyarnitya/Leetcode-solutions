class Solution {
    public static int solve(int idx,int[] nums, Integer[]dp){

        if(idx>=nums.length) return 0;

        if(dp[idx]!= null) return dp[idx];

        //steal
        int take = nums[idx] + solve(idx+2,nums,dp);
        int nottake = 0 + solve(idx+1,nums,dp);
        return dp[idx] = Math.max(take,nottake);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        Integer[] dp = new Integer[n];

        return solve(0,nums,dp);
    }
}
// class Solution {
//     // public int solve(int[] nums, int idx,int[] dp){
//     //     if(idx==0){
//     //         return nums[idx];
//     //     }
//     //     if(idx<0){
//     //         return 0;
//     //     }
//     //     if(dp[idx] != -1){
//     //         return dp[idx];
//     //     }
//     //     int pick = nums[idx] + solve(nums,idx-2, dp);
//     //     int notpick = 0+ solve(nums, idx-1, dp);
//     //     return dp[idx] = Math.max(pick,notpick);
//     // }
//     public int rob(int[] nums) {
//         int dp[]  = new int[nums.length];
        
//         // Arrays.fill(dp, -1);
//         // return solve(nums, nums.length-1, dp);
//     }
// }
