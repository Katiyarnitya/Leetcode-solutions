class Solution {
    static Integer[][] dp;
    public static int solve(int idx, int k, int[][] events){
        int n = events.length;
        if(idx>=n || k == 0){
            return 0;
        }
        if(dp[idx][k] != null) return dp[idx][k];

        // nottake
        int nottake = solve(idx+1,k,events);

        int next = findNextIdx(idx,events);
        int take = events[idx][2] + solve(next,k-1,events);
        return dp[idx][k] = Math.max(take, nottake);
    }
    public static int findNextIdx(int idx, int[][] events){
        int low = idx+1;
        int high = events.length-1;

        int ans = events.length;
        int end = events[idx][1];

        while(low<=high){
            int mid = low + ((high-low)>>1);
            
            if(events[mid][0]>end){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int maxValue(int[][] events, int k) {
        
        int n = events.length;
        Arrays.sort(events, (a,b) -> Integer.compare(a[0],b[0]));

        dp = new Integer[n][k+1];

        return solve(0,k,events);
    }
}