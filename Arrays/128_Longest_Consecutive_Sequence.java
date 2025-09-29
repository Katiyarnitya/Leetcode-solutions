class Solution {
   public int longestConsecutive(int[] nums) {
      int n = nums.length;
      int currCount = 0;
      int longest = 1;
      int last_smallest = Integer.MIN_VALUE;

      if (n == 0) {
         return 0;
      }
      Arrays.sort(nums);
      for (int i = 0; i < n; i++) {
         if (nums[i] - 1 == last_smallest) {
            currCount = currCount + 1;
            last_smallest = nums[i];
         } else if (nums[i] != last_smallest) {
            currCount = 1;
            last_smallest = nums[i];
         }
         longest = Math.max(longest, currCount);
      }
      return longest;
   }
}