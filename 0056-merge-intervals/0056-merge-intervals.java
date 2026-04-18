class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length;
        ArrayList<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int i=1;i<n;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(prevEnd>= currStart){
                prevEnd = Math.max(prevEnd, currEnd);
            }else{
                ans.add(new int[]{prevStart, prevEnd});
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }
        ans.add(new int[]{prevStart,prevEnd});

        return ans.toArray(new int[ans.size()][]);

        
    }
}
// class Solution {
//     public int[][] merge(int[][] intervals) {
        
//         ArrayList<int[]> merged = new ArrayList<>();
//         int n = intervals.length;
//         Arrays.sort(intervals,(a,b) -> Integer.compare(a[0], b[0]));
//         int startA = intervals[0][0];
//         int endA = intervals[0][1];

//         for(int i=1; i<n; i++){

//             int startB = intervals[i][0];
//             int endB = intervals[i][1];

//             if(endA >= startB){
//                 endA = Math.max(endA, endB);
//             }else{
//                 merged.add(new int[]{startA,endA});
//                 startA = startB;
//                 endA = endB;
//             }
//         }
//         merged.add(new int[]{startA, endA});
//         return merged.toArray(new int[merged.size()][]);
//     }
// }
