class Solution {
    public int lowerBound(ArrayList<Integer> temp, int targ){
            int low = 0;
            int high = temp.size() - 1;
            

            while(low<=high){
                int mid = low + (high-low) / 2;
                if(temp.get(mid) == targ){
                return mid;
                }else if( temp.get(mid) > targ){ //left
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return low;
    }
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        // Using Binary search
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);

        for(int i=1;i<n;i++){
            if(nums[i]>temp.get(temp.size()-1)){
                temp.add(nums[i]);
            }else{
                temp.set(lowerBound(temp, nums[i]),nums[i]);
            }
        }
        return temp.size();

    }
    public int maxEnvelopes(int[][] envelopes) {
         int n = envelopes.length;

        // Step 1: sort (both ascending)
        Arrays.sort(envelopes, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        // Step 2: DP
        for(int i = 0; i < n; i++){

            for(int j = 0; j < i; j++){

                if(envelopes[j][0] < envelopes[i][0] &&
                   envelopes[j][1] < envelopes[i][1]){

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
