class Solution {
    public boolean isPossible(int day, int m, int k, int[]bloomDay){

        int n = bloomDay.length;

        int  noOfBouq = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            if(bloomDay[i]<=day){
                count++;
            }else{
                noOfBouq +=(count/k);
                count = 0;
            }
        }
        noOfBouq +=(count/k);

        if(noOfBouq>=m){
            return true;
        }else{
            return false;
        }
    }
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;

        if(n<m*k) return -1;

        int low = 0;
        int high = 0;
        for(int i=0; i<n; i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }

        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(isPossible(mid,m,k,bloomDay)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}