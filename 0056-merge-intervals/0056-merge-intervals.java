class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> merged = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
        int startA = intervals[0][0];
        int endA = intervals[0][1];

        for(int i=1; i<n; i++){

            int startB = intervals[i][0];
            int endB = intervals[i][1];

            if(endA >= startB){
                endA = Math.max(endA, endB);
            }else{
                merged.add(new int[]{startA,endA});
                startA = startB;
                endA = endB;
            }
        }
        merged.add(new int[]{startA, endA});
        return merged.toArray(new int[merged.size()][]);
    }
}
