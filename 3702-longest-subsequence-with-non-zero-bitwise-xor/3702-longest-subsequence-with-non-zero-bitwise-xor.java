class Solution {
    public int longestSubsequence(int[] nums) {
        
        int n = nums.length;

        boolean allZero = true;

        int XORofAllNums = 0;
        for(int i=0; i<n;i++){
            XORofAllNums ^= nums[i];
            if(nums[i] != 0 ){
                allZero = false;
            }
        }

        if(allZero){
            return 0;
        }else{
            if(XORofAllNums!=0){
                return n;
            }else{
                return n-1;
            }
        }
    }
}