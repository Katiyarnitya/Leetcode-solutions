class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        int n = s.length();

        int left = 0;
        int ones = 0;

        int minLen = Integer.MAX_VALUE;
        String answer = "";

        for (int right = 0; right < n; right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            // We have more than k ones
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // We have exactly k ones
            if (ones == k) {

                // Remove unnecessary zeros from the left
                while (s.charAt(left) == '0') {
                    left++;
                }

                int len = right - left + 1;
                String current = s.substring(left, right + 1);

                if (len < minLen) {
                    minLen = len;
                    answer = current;
                } else if (len == minLen && current.compareTo(answer) < 0) {
                    answer = current;
                }
            }
        }

        return answer;
    }
}