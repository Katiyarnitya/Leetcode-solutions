class Solution {
   public long splitArray(int[] nums) {

      int n = nums.length;
      boolean[] inc = new boolean[n];
      boolean[] dec = new boolean[n];
      long[] prefix = new long[n];

      inc[0] = true;
      for (int i = 1; i < n; i++) {
         if (nums[i - 1] < nums[i]) {
            inc[i] = true;
         } else {
            break;
         }
      }

      dec[n - 1] = true;
      for (int i = n - 2; i >= 0; i--) {
         if (nums[i] > nums[i + 1]) {
            dec[i] = true;
         } else {
            break;
         }
      }

      prefix[0] = nums[0];
      for (int i = 1; i < n; i++) {
         prefix[i] = prefix[i - 1] + nums[i];
      }

      long diff = 0;
      long minDiff = 1000000000000000L; // 10^15 as long

      for (int i = 0; i < n - 1; i++) {
         if (inc[i] && dec[i + 1]) {
            diff = Math.abs(prefix[i] - (prefix[n - 1] - prefix[i]));
            minDiff = Math.min(minDiff, diff);
         }

      }

      return (minDiff == 1e15) ? -1 : minDiff;
   }
}