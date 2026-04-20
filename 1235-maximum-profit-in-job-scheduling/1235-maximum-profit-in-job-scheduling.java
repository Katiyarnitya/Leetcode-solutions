class Solution {
    public static int binarySearch( int low, int high, int[][] arr, int targ){
        int ans = arr.length;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid][0]>=targ){
                ans= mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int solve(int idx, int[][] arr, Integer[] dp){
        if(idx==arr.length) return 0;

        if(dp[idx] != null) return dp[idx];

        int nottake = 0 + solve(idx+1,arr,dp);
        int nextIdx = binarySearch(idx+1,arr.length-1,arr,arr[idx][1]);

        int take = arr[idx][2] + solve(nextIdx , arr, dp);

        return dp[idx] = Math.max(take,nottake);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        
        int n = startTime.length;
        int[][] arr = new int[n][3];

        for(int i=0;i<n;i++){
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }
        Arrays.sort(arr, (a,b)-> a[0]-b[0]);

        Integer[] dp = new Integer[n];
        return solve(0,arr,dp);
    }
}