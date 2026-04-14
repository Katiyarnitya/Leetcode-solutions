class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        
        int n = nums.length;
        int minValue = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(nums[i] == target){
                minValue = Math.min(minValue, Math.abs(i-start));
            }
        }
        return minValue;
    }
}