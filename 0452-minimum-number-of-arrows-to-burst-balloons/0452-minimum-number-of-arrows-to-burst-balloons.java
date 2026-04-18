class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        Arrays.sort(points,(a,b) -> Integer.compare(a[0],b[0]));

        int prevS = points[0][0];
        int prevE = points[0][1];

        int arrows = 1;

        for(int i=1;i<n;i++){
            int currS  = points[i][0];
            int currE = points[i][1];

            if(currS<=prevE){ // overlap
                // shrink to intersection
                prevE = Math.min(prevE, currE);
            }else{
                arrows++;
                prevE = currE;
                prevS = currS;
            }
        }
        return arrows;
    }
}