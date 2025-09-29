class Solution {
   public void reverse(int[] nums, int s, int e) {
      while (s < e) {
         int temp = nums[s];
         nums[s] = nums[e];
         nums[e] = temp;
         s++;
         e--;
      }
   }

   public void swap(int[] nums, int s, int e) {
      int temp = nums[s];
      nums[s] = nums[e];
      nums[e] = temp;
   }

   public void nextPermutation(int[] nums) {
      int n = nums.length;
      int idx = -1;
      for (int i = n - 2; i >= 0; i--) {
         if (nums[i] < nums[i + 1]) {
            idx = i;
            break;
         }
      }

      if (idx == -1) {
         reverse(nums, 0, n - 1);
         return;
      }

      for (int i = n - 1; i >= 0; i--) {
         if (nums[i] > nums[idx]) {
            swap(nums, i, idx);
            break;
         }
      }
      reverse(nums, idx + 1, n - 1);
   }
}