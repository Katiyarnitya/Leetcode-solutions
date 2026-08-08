class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        // suf[j] = index where word2[j...] can start matching exactly
        int[] suf = new int[m];

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {
            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                suf[j] = -1;
            } else {
                suf[j] = i;
                i--;
            }
        }

        int[] ans = new int[m];

        int pos = 0;
        boolean changed = false;

        for (int j = 0; j < m; j++) {

            while (pos < n) {

                // Normal matching
                if (word1.charAt(pos) == word2.charAt(j)) {
                    ans[j] = pos;
                    pos++;
                    break;
                }

                // Use our one allowed change
                if (!changed) {

                    // If this is the last character
                    if (j == m - 1) {
                        ans[j] = pos;
                        pos++;
                        changed = true;
                        break;
                    }

                    // Remaining characters must match exactly
                    if (suf[j + 1] > pos) {
                        ans[j] = pos;
                        pos++;
                        changed = true;
                        break;
                    }
                }

                pos++;
            }

            if (pos >= n && ans[j] == 0 && j != 0) {
                return new int[0];
            }
        }

        return ans;
    }
}