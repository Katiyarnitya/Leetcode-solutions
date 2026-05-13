class Solution {
    public int maximumScore(int[] nums, int k) {
        
        int n = nums.length;
        int i = k;
        int j = k;
        int currMin = nums[k];
        int res = nums[k];

        while(i>0 || j<n-1){

            int leftVal = (i>0) ? nums[i-1] : 0;
            int rightVal = (j<n-1) ? nums[j+1] : 0;

            if(leftVal > rightVal){
                i--;
                currMin = Math.min(currMin, nums[i]);
            }else{
                j++;
                currMin = Math.min(currMin, nums[j]);
            }

            res = Math.max(res, currMin*(j-i+1));
        }
        return res;
    }
}