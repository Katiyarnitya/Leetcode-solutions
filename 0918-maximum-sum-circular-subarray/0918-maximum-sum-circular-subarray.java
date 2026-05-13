class Solution {
    public int minKadanes(int[] arr){
        int n = arr.length;
        int mini = Integer.MAX_VALUE;
        int curr = 0;
        for(int i=0;i<n;i++){
            curr += arr[i];
            mini = Math.min(mini,curr);
            if(curr>0){
                curr=0;
            }
        }
        return mini;
    }

    public int maxKadanes(int[] arr){
        int n = arr.length;
        int maxi = Integer.MIN_VALUE;
        int curr = 0;

        for(int i=0;i<n;i++){
            curr += arr[i];
            maxi = Math.max(maxi,curr);
            if(curr<0){
                curr = 0;
            }
        }
        return maxi;
    }
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;

        int maxSum = maxKadanes(nums); // case :1

        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        
        int minSum = minKadanes(nums); 
        int circularSum = totalSum - minSum; // case : 2

       if(maxSum>0){
            return Math.max(maxSum,circularSum);
       }else{
            return maxSum;
       }
    }
}