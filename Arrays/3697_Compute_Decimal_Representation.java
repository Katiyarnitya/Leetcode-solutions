class Solution {
   public int[] decimalRepresentation(int n) {

      List<Integer> al = new ArrayList<>();
      String numStr = String.valueOf(n);
      int len = numStr.length();

      for (int i = 0; i < len; i++) {
         int digit = numStr.charAt(i) - '0';
         if (digit != 0) {
            int power = (int) Math.pow(10, len - i - 1);
            al.add(digit * power);
         }

      }

      int[] result = new int[al.size()];
      for (int i = 0; i < al.size(); i++) {
         result[i] = al.get(i);
      }
      return result;
   }
}