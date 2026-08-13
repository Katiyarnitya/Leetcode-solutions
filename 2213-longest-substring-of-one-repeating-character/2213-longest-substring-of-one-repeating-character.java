class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int max;
        int len;

        Node(char leftChar, char rightChar,
             int prefix, int suffix, int max, int len) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.max = max;
            this.len = len;
        }
    }

    Node[] tree;
    char[] arr;

    public int[] longestRepeating(String s, String queryCharacters,
                                  int[] queryIndices) {

        int n = s.length();

        arr = s.toCharArray();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {

            int index = queryIndices[i];
            char ch = queryCharacters.charAt(i);

            // Perform query
            arr[index] = ch;

            // Update segment tree
            update(1, 0, n - 1, index);

            // Root contains answer for entire string
            ans[i] = tree[1].max;
        }

        return ans;
    }

    void build(int node, int l, int r) {

        if (l == r) {

            char ch = arr[l];

            tree[node] = new Node(
                ch, ch,
                1, 1, 1,
                1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(int node, int l, int r, int index) {

        if (l == r) {

            char ch = arr[l];

            tree[node] = new Node(
                ch, ch,
                1, 1, 1,
                1
            );

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index);
        } else {
            update(node * 2 + 1, mid + 1, r, index);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    Node merge(Node left, Node right) {

        int len = left.len + right.len;

        int prefix = left.prefix;
        int suffix = right.suffix;

        int max = Math.max(left.max, right.max);

        // The two segments can connect
        if (left.rightChar == right.leftChar) {

            // A repeating substring crosses the boundary
            max = Math.max(
                max,
                left.suffix + right.prefix
            );

            // Entire left segment is one character
            if (left.prefix == left.len) {
                prefix = left.len + right.prefix;
            }

            // Entire right segment is one character
            if (right.suffix == right.len) {
                suffix = right.len + left.suffix;
            }
        }

        return new Node(
            left.leftChar,
            right.rightChar,
            prefix,
            suffix,
            max,
            len
        );
    }
}