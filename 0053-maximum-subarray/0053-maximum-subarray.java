class Solution {
    public int maxSubArray(int[] nums) {
        
        int n = nums.length;
        int curr=0;
        int maxi = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            curr+=nums[i];
            maxi = Math.max(maxi,curr);
            if(curr<0){
                curr = 0;
            }
            
        }
        return maxi;
    }
}

// class Solution {
//     public int maxSubArray(int[] nums) {

//         int n= nums.length;
//         int currSum = 0;
//         int maxSum = Integer.MIN_VALUE;

//         for(int i=0;i<n;i++){
//             currSum += nums[i];
//             maxSum = Math.max(maxSum,currSum);
//             if(currSum<0){
//                 currSum=0;
//             }
//         }
//         return maxSum;
//     }
// }