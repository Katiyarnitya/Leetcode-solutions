import java.util.*;

class Solution {
    public String smallestNumber(String num, long t) {
        int[] req = f(t);
        if (req == null) return "-1";

        int n = num.length(), z = num.indexOf('0');
        int maxLen = (z == -1) ? n : z;
        int[][] pref = new int[n + 1][4];
        pref[0] = req;

        for (int i = 0; i < maxLen; i++) pref[i + 1] = red(pref[i], num.charAt(i) - '0');

        // Check if the original prefix (if zero-free) already satisfies t
        if (maxLen == n && minL(pref[n]) == 0) {
            return num;
        }

        // Try matching a prefix of length i and incrementing digit at position i
        for (int i = maxLen; i >= 0; i--) {
            int start = (i < n) ? (num.charAt(i) - '0' + 1) : 1;
            for (int d = start; d <= 9; d++) {
                int[] next = red(pref[i], d);
                if (minL(next) <= n - 1 - i)
                    return num.substring(0, i) + d + suf(next, n - 1 - i);
            }
        }
        return suf(req, Math.max(n + 1, minL(req)));
    }

    private int[] f(long t) {
        int[] c = new int[4], p = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) while (t % p[i] == 0) { c[i]++; t /= p[i]; }
        return t == 1 ? c : null;
    }

    private int[] red(int[] r, int d) {
        if (d <= 1) return r.clone();
        int[] n = r.clone(), df = f(d);
        for (int i = 0; i < 4; i++) n[i] = Math.max(0, n[i] - df[i]);
        return n;
    }

    private int minL(int[] r) {
        int p2 = r[0], p3 = r[1], c8 = p2 / 3, c9 = p3 / 2;
        p2 %= 3; p3 %= 2;
        int c6 = (p2 > 0 && p3 > 0) ? 1 : 0;
        if (c6 == 1) { p2--; p3--; }
        return c8 + c9 + c6 + (p2 / 2) + (p2 % 2) + p3 + r[2] + r[3];
    }

    private String suf(int[] r, int len) {
        int p2 = r[0], p3 = r[1], p5 = r[2], p7 = r[3];
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < p5; i++) d.add(5);
        for (int i = 0; i < p7; i++) d.add(7);
        int c8 = p2 / 3, c9 = p3 / 2;
        p2 %= 3; p3 %= 2;
        if (p2 == 2 && p3 == 1) { d.add(2); d.add(6); p2 = p3 = 0; }
        else if (p2 == 1 && p3 == 1) { d.add(6); p2 = p3 = 0; }
        if (p2 == 2) d.add(4); else if (p2 == 1) d.add(2);
        if (p3 == 1) d.add(3);
        for (int i = 0; i < c8; i++) d.add(8);
        for (int i = 0; i < c9; i++) d.add(9);
        while (d.size() < len) d.add(1);
        Collections.sort(d);
        StringBuilder sb = new StringBuilder();
        for (int x : d) sb.append(x);
        return sb.toString();
    }
}