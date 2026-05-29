class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;
        int low = 0;
        int high = n-1;

        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[low]<=nums[mid]){ //Left orte
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else if(nums[mid]<nums[high]){
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;


        // int n= nums.length;
        // int min =0;
        // boolean isSorted = true;
        // for(int i =0;i<n-1;i++){
        //     if(nums[i]>nums[i+1]){
        //         isSorted = false;
        //         min = nums[i+1];
        //         break;
        //     }
        // }
        // if(isSorted){
        //     min = nums[0];
        // }
        // return min;
    }
}