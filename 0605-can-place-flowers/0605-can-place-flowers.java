class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int len = flowerbed.length;
        if(n==0) return true;
        
        int count=0;

        for(int i=0;i<len;i++){
            if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==len-1 || flowerbed[i+1]==0)){
                flowerbed[i] = 1;
                count++;
            }
        }
        return (count>=n) ? true : false;
    }
}