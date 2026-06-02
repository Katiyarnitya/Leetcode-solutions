class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int n = landStartTime.length;
        int m = waterStartTime.length;

        int minTime = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int landRidePick = landStartTime[i] + landDuration[i];
            int mini = Integer.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                mini = Math.min(
                    mini,
                    Math.max(landRidePick, waterStartTime[j]) + waterDuration[j]
                );
            }

            minTime = Math.min(minTime, mini);
        }

        for (int i = 0; i < m; i++) {
            int waterRidePick = waterStartTime[i] + waterDuration[i];
            int mini = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                mini = Math.min(
                    mini,
                    Math.max(waterRidePick, landStartTime[j]) + landDuration[j]
                );
            }

            minTime = Math.min(minTime, mini);
        }

        return minTime;
    }
}