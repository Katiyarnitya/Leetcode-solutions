class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;
        
        int currMin = nums[0];
        int miniSum = nums[0];
        int currMax = nums[0];
        int maxSum = nums[0];
        int totalSum = nums[0];

        for(int i=1;i<n;i++){
            totalSum+=nums[i];
            currMax = Math.max(nums[i], currMax + nums[i]);
            maxSum =  Math.max(maxSum, currMax);
            currMin = Math.min(nums[i],currMin+nums[i]);
            miniSum = Math.min(currMin, miniSum);
        }

        if(maxSum<0) return maxSum;
        return Math.max(maxSum, totalSum-miniSum);
    }
}