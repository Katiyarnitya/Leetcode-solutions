class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int repEle = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[i+1]){
                repEle = nums[i];
                break;
            }
        }
        return repEle;
    }
}