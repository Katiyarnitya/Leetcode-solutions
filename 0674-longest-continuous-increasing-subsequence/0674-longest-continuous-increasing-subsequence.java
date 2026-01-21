class Solution {
    public int findLengthOfLCIS(int[] nums) {

        int len = 1;
        int maxi=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                len++;
            }else{
                len=1;
            }
            maxi = Math.max(maxi,len);
        }
        return maxi;
    
    }
}