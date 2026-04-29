class Solution {
    public boolean ispossible(int maxCap, int days, int[] weights){
        
        int daysReq = 1;
        int cap = 0;
        for(int wt : weights){
            cap += wt;
            if(cap>maxCap){
                daysReq++;
                cap = wt;
            }
        }
        if(daysReq<=days){
            return true;
        }else{
            return false;
        }
    }
    public int shipWithinDays(int[] weights, int days) {

        int n = weights.length;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int wt : weights){
            maxi = Math.max(maxi, wt);
            sum += wt;
        }
        int low = maxi;
        int high = sum;
        int ans = sum;

        while(low<=high){
            int mid  = low + (high-low)/2;

            if(ispossible(mid,days,weights)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return ans;
    }
}