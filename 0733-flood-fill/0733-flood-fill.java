class Solution {
    static int rowL;
    static int colL;

    public void DFS(int r, int c, int color, int[][] image,int pixel, int[] dr, int[] dc){
        if(r<0 || c<0 || r>=rowL || c>=colL || image[r][c] !=pixel || image[r][c] == color){
            return;
        }
        image[r][c] = color;
        for(int i=0;i<dr.length;i++){
            int newR = r+dr[i];
            int newC = c+dc[i];
            DFS(newR, newC, color, image,pixel, dr,dc);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rowL = image.length;
        colL = image[0].length;

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        DFS(sr,sc,color,image,image[sr][sc],dr,dc);
        return image;
    }
}