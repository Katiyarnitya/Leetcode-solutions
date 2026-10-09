class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int open = 0;
        int insertions = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
            } else {
                // Check whether the next character is also ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    insertions++;
                }

                // Match the required '))' with an opening '('
                if (open > 0) {
                    open--;
                } else {
                    // Insert an opening '('
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two closing ')'
        insertions += open * 2;

        return insertions;
    }
}