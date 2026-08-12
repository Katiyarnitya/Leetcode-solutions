class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        int n = nums.length;

        int l = 0;
        int longestGoodSubarray = 0;
        HashMap<Integer,Integer> map = new HashMap<>();

        boolean isFreqGreaterK = false;
        for(int r=0; r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
             if(map.get(nums[r]) > k){
                isFreqGreaterK = true;
             }

            while(isFreqGreaterK){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[r]) <= k){
                    isFreqGreaterK = false;
                }
                l++;
            }

            longestGoodSubarray = Math.max(longestGoodSubarray,r-l+1);
        }
        return longestGoodSubarray;
    }
}