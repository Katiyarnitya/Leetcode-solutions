class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == ' ') i++;

        if (i == n) return 0;

        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        int result = 0;

        while (i < n) {
            char ch = s.charAt(i);

            if (ch < '0' || ch > '9') break;

            int digit = ch - '0';

            // 4. overflow check BEFORE multiplying
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}