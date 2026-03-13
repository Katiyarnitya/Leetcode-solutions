class Solution {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 0;
        long high = (long)1e18;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (can(mid, mountainHeight, workerTimes)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    boolean can(long time, int height, int[] workerTimes) {

        long total = 0;

        for (int t : workerTimes) {

            long left = 0, right = height;

            while (left <= right) {
                long mid = left + (right - left) / 2;

                long required = (long)t * mid * (mid + 1) / 2;

                if (required <= time) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            total += right;

            if (total >= height)
                return true;
        }

        return false;
    }
}