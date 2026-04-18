class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[10];

        for (int d : digits) freq[d]++;

        for (int num = 100; num <= 998; num += 2) { 
            int a = num / 100;          // hundreds digit
            int b = (num / 10) % 10;    // tens digit
            int c = num % 10;           // ones digit

            int[] curr = new int[10];
            curr[a]++;
            curr[b]++;
            curr[c]++;
            boolean ok = true;
            for (int d = 0; d < 10; d++) {
                if (curr[d] > freq[d]) { // if we use a digit more times than available
                    ok = false;
                    break;
                }
            }

            if (ok) res.add(num);
        }

        // Convert to array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);

        return ans;
    }
}