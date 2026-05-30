class Solution {
    public int helper(int k, int[]piles, int h){
        int time = 0;

        for(int i=0;i<piles.length;i++){
            time += Math.ceil((double)piles[i]/k);
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            maxi = Math.max(maxi,piles[i]);
        }
        int low = 1;
        int high = maxi;
        int ans = 1;
        while(low<=high){
            int mid = low +(high - low)/2;
            if(helper(mid,piles,h)<=h){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}