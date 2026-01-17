class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        
        int n = bottomLeft.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                //Width
                int x2=Math.min(topRight[i][0],topRight[j][0]);
                int x1=Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int width = x2-x1;

                //Height
                int y2=Math.min(topRight[i][1],topRight[j][1]);
                int x1=Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                int width = y2-y1;

                int side = Math.min(width,height);


            }
        }
    }
}