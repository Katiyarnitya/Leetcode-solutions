class Solution {
    static Integer[] dp;
    public int solve(int idx, int nums[]){
        if(idx>=nums.length-1) return 0;

        if(dp[idx] !=null) return dp[idx];
        int minOpr = (int)1e9;
        int maxJump = Math.min(idx + nums[idx], nums.length - 1);
        for(int j=idx+1; j<= maxJump; j++){
            minOpr = Math.min(minOpr, 1 + solve(j,nums));
        }
        return dp[idx] = minOpr;
    }
    public int jump(int[] nums) {
        
        int n = nums.length;
        dp = new Integer[n];
        return solve(0,nums);

        // int farthest = 0;
        // int count = 0;
        // int i=0;
        // while(i<n && farthest<n-1){
        //     int curr = nums[i];
        //     for(int j=i+1; j<=i+curr; j++){
        //         farthest = Math.max(farthest, j + nums[j]);
        //     }
        //     i = farthest;
        //     count++;
        // }
        // return count;
    }
}

// class Solution {
//     public int jump(int[] nums) {
        
//         int n = nums.length;
//         int noOfJump =0;
//         int left=0;
//         int right=0;

//         while(right<n-1){
//             int fartherst = 0;
//             for(int i=left;i<=right;i++){
//                 fartherst = Math.max(fartherst,i+nums[i]);
//             }
//             noOfJump+=1;
//             left=right+1;
//             right=fartherst;
//         }
//         return noOfJump;
//     }
// }