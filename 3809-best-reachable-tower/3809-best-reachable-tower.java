class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int n = towers.length;
        int maxQ = -1;
        int[] ans = {-1,-1};
        for(int i=0;i<n;i++){
            int manDis = Math.abs(towers[i][0]-center[0]) + Math.abs(towers[i][1]-center[1]);
            
            if(manDis<=radius){//Reachable
                if(maxQ < towers[i][2]){
                    maxQ = towers[i][2];
                    ans[0] = towers[i][0];
                    ans[1] = towers[i][1];
                }else if(maxQ == towers[i][2]){ // if quality is equal
                    if(towers[i][0]<= ans[0] && towers[i][1] < ans[1]){
                        ans[0] = towers[i][0];
                        ans[1] = towers[i][1];
                    }
                }
            }
        }
        return ans;
    }
}