class Solution {

    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {

            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {

        int n = coins.length;
        long count = 0;

        // Every non-empty subset
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {

                    lcm = getLCM(lcm, coins[i]);

                    // No multiple of this LCM can be <= x
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long multiples = x / lcm;

            // Odd number of coins -> add
            // Even number of coins -> subtract
            if (Integer.bitCount(mask) % 2 == 1) {
                count += multiples;
            } else {
                count -= multiples;
            }
        }

        return count;
    }

    private long getLCM(long a, long b) {
        return (a / getGCD(a, b)) * b;
    }

    private long getGCD(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}