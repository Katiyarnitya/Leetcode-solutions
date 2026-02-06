class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        if(n==1)return 0;
        Arrays.sort(nums);
        int left=0;
        int len = 0;
        for(int right=0;right<n;right++){
            while((long)nums[right]> (long)k*nums[left]){
                left++;
            }
            len = Math.max(len,right-left+1);
        }
        return n-len;
    }
}