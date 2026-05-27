class Solution {
    public int findLB(int[] arr, int target,int n){
        int low = 0;
        int high = n-1;
        int ans = n;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(arr[mid]>=target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
    public int searchInsert(int[] nums, int target) {
        //THIS PROBLEM IS SIMILAR TO FINDING THE LOWERBOUND

         return findLB(nums,target,nums.length);

        // int left =0;
        // int right =nums.length-1;
        // while(left<=right){
        //     int mid = left+(right-left)/2;
        //     if(nums[mid]==target){
        //         return mid;
        //     }else if(nums[mid]>target){
        //         right=mid-1;
        //     }else{
        //         left=mid+1;
        //     }
        // }
        // return left;
    }
}