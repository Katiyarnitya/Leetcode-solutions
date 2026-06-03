class Solution {
    public boolean isPossible(int[]nums, int mid, int threshold){
        int n = nums.length;

        int sum = 0;
        for(int i=0;i<n;i++){
            sum += (Math.ceil((double)nums[i] / (double)mid));
        }
        if(sum<=threshold){
            return true;
        }else{
            return false;
        }
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        int n = nums.length;

        int low = 1;
        int high = 1;

        for(int i=0;i<n;i++){
            high = Math.max(high, nums[i]);
        }

        int ans = 0;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(nums,mid,threshold)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}