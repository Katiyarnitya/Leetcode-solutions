class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int hLen=1;
        for(int i=0;i<hBars.length-1;i++){
            if(hBars[i] = hBars[i+1]+1){
                hLen++;
            }else{
                hLen=1;
            }
        }
        

    }
}