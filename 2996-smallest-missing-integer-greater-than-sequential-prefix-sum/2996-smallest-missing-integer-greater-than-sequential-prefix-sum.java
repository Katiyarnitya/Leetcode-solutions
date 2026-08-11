class Solution {
    public int missingInteger(int[] nums) {
        
        int n = nums.length;

        int longestSeqPrefixLength = 1;
        int longestPrefixSum = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]+1){
                longestSeqPrefixLength++;
                longestPrefixSum += nums[i];
            }else{
                break;
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }

        while(set.contains(longestPrefixSum)){
            longestPrefixSum++;
        }
        return longestPrefixSum;
    }
}