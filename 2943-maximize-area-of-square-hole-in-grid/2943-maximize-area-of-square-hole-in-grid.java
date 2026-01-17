class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int height=1;
        int maxH = 1;
        for(int i=0;i<hBars.length-1;i++){
            if(hBars[i]+1 == hBars[i+1]){
                height++;
            }else{
                height=1;
            }
            maxH = Math.max(maxH,height);
        }

        int width=1;
        int maxV = 1;
        for(int i=0;i<vBars.length-1;i++){
            if(vBars[i]+1 == vBars[i+1]){
                width++;
            }else{
                width=1;
            }
            maxV = Math.max(maxV,width);
        }
        return Math.min(maxV+1,maxH+1) * Math.min(maxV+1,maxH+1);
    }
}