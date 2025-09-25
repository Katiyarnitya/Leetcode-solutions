class Solution {
   public void reverse(int[] nums, int left, int right) {
      while (left < right) {
         int temp = nums[left];
         nums[left] = nums[right];
         nums[right] = temp;
         left++;
         right--;
      }
   }

   public void rotate(int[] nums, int k) {

      int n = nums.length;
      k = k % n;

      // OPTIMIZED

      reverse(nums, 0, n - k - 1); // Reverse n-k elements from start
      reverse(nums, n - k, n - 1);// Reverse last k elemets
      reverse(nums, 0, n - 1);// Reverse whole array

      // BRUTE FORCE

      // int[] temp = new int[n];
      // // Putting in temp
      // int j=0;
      // for(int i=n-1;i>=n-k;i--){
      // temp[j] = nums[i];
      // j++;
      // }
      // //SHifting
      // for(int i=n-k-1; i>=0;i--){
      // nums[i+k] = nums[i];
      // }
      // //Putting back
      // int idx=k-1;
      // for(int i=0;i<k;i++){
      // nums[i] = temp[idx];
      // idx--;
      // }

   }
}