class Solution {
    public int finishTime(int[] activity1,int[] duration1, int[]activity2, int[]duration2){

        int n = activity1.length;

        int activity1FinishTime = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            activity1FinishTime = Math.min(activity1FinishTime,activity1[i]+duration1[i]);
        }

        int m = activity2.length;

        int minTime = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            minTime = Math.min(minTime, Math.max(activity1FinishTime,activity2[i]) + duration2[i]);
        }
        return minTime;
    }
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int landThenWater = finishTime(landStartTime,landDuration,waterStartTime, waterDuration);
        int waterThenLand = finishTime(waterStartTime,waterDuration,landStartTime, landDuration);

        return Math.min(landThenWater, waterThenLand);
    }
}