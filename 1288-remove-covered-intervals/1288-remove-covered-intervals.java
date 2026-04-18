class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        int n = intervals.length;
        Arrays.sort(intervals, (a,b)->{
            if(a[0]==b[0]) return Integer.compare(b[1],a[1]);
            return Integer.compare(a[0],b[0]);
        });

        int startA = intervals[0][0];
        int endA = intervals[0][1];

        int remaining  = n;

        for(int i=1;i<n;i++){
            int startB = intervals[i][0];
            int endB = intervals[i][1];

            if(startA<=startB && endA>=endB){
                remaining --;
            }else{
                startA = startB;
                endA = endB;
            }
        }
        return remaining;
    }
}