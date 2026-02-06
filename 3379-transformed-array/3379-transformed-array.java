class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int[] result = new int[nums.length];
        int n = nums.length;

        for(int i=0;i<nums.length;i++){
            int idx;
            if(nums[i]>0){
                idx = (i+nums[i])%n;
                result[i] = nums[idx];
            }else if(nums[i]<0){
                idx= ((i + nums[i]) % n + n) % n;
                result[i] = nums[idx];
            }else{
                result[i] = nums[i];
            }
        }
        return result;
    }
}