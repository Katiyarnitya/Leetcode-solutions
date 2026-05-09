class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;

        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        leftMin[0] = nums[0];
        for(int i=1;i<n;i++){
            leftMin[i] =Math.min(leftMin[i-1], nums[i]);
        }

        rightMax[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMax[i] =Math.max(rightMax[i+1], nums[i]);
        }

        for(int i=1;i<n-1;i++){
            if(leftMin[i-1] < nums[i] &&
               nums[i] < rightMax[i+1]){
                return true;
            }
        }

        // TLE
        // int[] dp = new int[n];
        // Arrays.fill(dp, 1);
        // for(int curr=0;curr<n;curr++){
        //     for(int prev=0;prev<curr;prev++){
        //         if(nums[prev] < nums[curr]){
        //             dp[curr] = Math.max(dp[curr],1 + dp[prev]);
        //             if(dp[curr] >= 3){
        //                 return true;
        //             }
        //         }
        //     }
        // }

        return false;
    }
}