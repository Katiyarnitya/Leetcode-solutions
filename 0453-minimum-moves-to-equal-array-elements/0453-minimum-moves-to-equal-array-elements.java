class Solution {
    public int minMoves(int[] nums) {
        
        int n = nums.length;
        int minElement = Integer.MAX_VALUE;
        int sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            minElement = Math.min(minElement,nums[i]);
        }

        return sum - (n * minElement);
    }
}