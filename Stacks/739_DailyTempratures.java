class Solution {
   public int[] dailyTemperatures(int[] tempratures) {

      int n = tempratures.length;

      // Brute force
      int[] arr = new int[tempratures.length];
      for (int i = 0; i < n; i++) {
         for (int j = i + 1; j < n; j++) {
            if (tempratures[i] < tempratures[j]) {
               arr[i] = j - i;
               break;
            }
         }
      }
      return arr;

      // OPTIMIZED
      // O(2N) -TC
      // O(N) -SC bcz. ans is mentioned in ques then only considering stack
      int[] ans = new int[n];
      Stack<Integer> st = new Stack<>();
      for (int i = 0; i < n; i++) {
         while (!st.isEmpty() && tempratures[i] > tempratures[st.peek()]) {
            int idx = st.pop();
            ans[idx] = i - idx;// diff between the warmer day and curr. day
         }
         st.push(i);
      }
      return ans;
   }
}
