class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = Integer.MIN_VALUE;

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(matrix[row][col] == 1 && row>0){
                    matrix[row][col] += matrix[row-1][col];
                }
            }
            Integer[] heights = Arrays.stream(matrix[row]).boxed().toArray(Integer[]::new);
            Arrays.sort(heights, Collections.reverseOrder());

            for(int i=0;i<n;i++){
                int base = i+1;
                int area = heights[i]*base;
                maxArea = Math.max(maxArea,area);
            }
        }
        return maxArea;
    }
}