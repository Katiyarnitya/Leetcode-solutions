class Solution {
   long power(long base, long exp, long mod) {
      long result = 1;
      while (exp > 0) {
         if ((exp & 1) == 1) { // if current bit is 1
            result = (result * base) % mod;
         }
         base = (base * base) % mod; // square the base
         exp >>= 1; // shift right (divide by 2)
      }
      return result;
   }

   public int countGoodNumbers(long n) {
      long mod = 1_000_000_007;
      long even_count = (n + 1) / 2; // 0-indexed even positions
      long odd_count = n / 2;

      long even_pow = power(5, even_count, mod); // all even indices
      long odd_pow = power(4, odd_count, mod); // all odd indices
      long total = (even_pow * odd_pow) % mod;
      return (int) total;
   }
}