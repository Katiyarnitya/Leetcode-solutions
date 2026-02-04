class Solution {
    public int minimumCost(int[] nums) {
        int cost = nums[0];

        int sec=Integer.MAX_VALUE;
        int third=Integer.MAX_VALUE;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<sec){
                third=sec;
                sec=nums[i];
            }else if(nums[i]<third){
                third = nums[i];
            }
        }
        return cost+sec+third;
    }
}