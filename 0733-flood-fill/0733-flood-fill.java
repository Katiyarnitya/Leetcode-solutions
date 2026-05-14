class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};

    public void dfs(int r, int c, int startC, int[][] image, int color, int m,int n){

        image[r][c] = color;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]!=color && image[nr][nc] == startC){
                dfs(nr,nc,startC, image,color,m,n);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       
       int m = image.length;
       int n = image[0].length;

       int startColor = image[sr][sc];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(sr,sc,startColor,image,color,m,n);
            }
        }
        return image;
    }
}