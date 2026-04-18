import java.util.*;

class Solution {

    int offset = 1000; // to handle negative sums
    int[][] dp;

    public int solve(int idx, int sum, int[] nums, int target){

        if(idx == nums.length){
            return sum == target ? 1 : 0;
        }

        if(dp[idx][sum + offset] != Integer.MIN_VALUE){
            return dp[idx][sum + offset];
        }

        int plus = solve(idx + 1, sum + nums[idx], nums, target);
        int minus = solve(idx + 1, sum - nums[idx], nums, target);

        return dp[idx][sum + offset] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {

        dp = new int[nums.length][2001];

        for(int i = 0; i < nums.length; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        return solve(0, 0, nums, target);
    }
}