class Solution {
    public int minOperations(int[] nums, int x) {
        
        // See we need to remove the elements either from start/last, that means we have to basically remove the prefix or suffix or prefix and suffix So that removed elements sum is equal to x with minimum elements removed.

        // So if we think in reverse : Part of nums from start(Prefix [Can be 0]) and Part of nums from last(Suffix[can be 0]) can be removed such that sum of removed parts is equal to x
        // This means we have left with a max length subarray that has sum = (totalsum - x)

        // Therefore problem changes to find a maximum length subarray that has sum equals to (totalSum-x);

        int n = nums.length;
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum==x){
            return n;
        }
        int requiredSum = totalSum-x;
        if (requiredSum < 0) {
            return -1;
        }

        int l=0;
        int sum = 0;
        int maxLength = 0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum>requiredSum){
                sum -= nums[l];
                l++;
            }
            if(sum==requiredSum){
                maxLength = Math.max(maxLength,r-l+1);
            }
        }
        return (maxLength==0) ? -1 : n-maxLength;
    }
}


// This solution will give TLE because :
// i → n possibilities
// j → n possibilities
// sum → x+1 possibilities
// O(n × n × x) 
// class Solution {
//     static int INF = (int)1e9;
//     public int solve(int i, int j, int sum, int x, int[]nums,Integer[][][] dp){

//         if(sum==x){
//             return 0;
//         }
//         if((sum>x) || (i>j && sum<x)){
//             return INF;
//         }
//         if(dp[i][j][sum]!=null) return dp[i][j][sum];

//         int first = solve(i+1,j,sum+nums[i],x,nums,dp);
//         int last = solve(i,j-1,sum+nums[j],x,nums,dp);
//         if(first != INF) first++;
//         if(last != INF) last++;
//         return dp[i][j][sum] = Math.min(first,last);
//     }
//     public int minOperations(int[] nums, int x) {
        
//         int n = nums.length;
//         Integer[][][] dp = new Integer[n][n][x+1];
//         if(solve(0,n-1,0,x,nums,dp)== INF){
//             return -1;
//         }
//         return solve(0,n-1,0,x,nums,dp);
//     }
// }