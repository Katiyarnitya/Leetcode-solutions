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

        // int[][] dp = new int[n+1][n+1];

        // for(int curr=n-1; curr>=0; curr--){
        //     for(int prev = curr-1; prev>=-1; prev--){
        //         int nottake = dp[curr+1][prev+1];
        //         int take = 0;
        //         if(prev == -1 || nums[curr]> nums[prev]){
        //             take = 1 + dp[curr+1][curr+1]; // dp[curr+!][prev]-> we acess prev as prev+1 therefore used curr+1
        //         }
                    
        //         dp[curr][prev+1] = Math.max(take,nottake);
        //     }
        // }
        // return dp[0][0]; // as real ans at d[0][-1] but -1 will accessed as -1+1 - > 0
    }
        // public int solve(int curr, int last, int[] nums, int[][] dp){
    //     if(curr == nums.length){
    //         return 0;
    //     }
    //     if(dp[curr][last+1] != null) return dp[curr][last+1];

    //     int nottake = solve(curr+1,last,nums,dp);
    //     int take = 0;
    //     if(last == -1 || nums[curr] > nums[last]){
    //         take = 1 + solve(curr+1, curr, nums, dp);
    //     }
    //     return Math.max(take,nottake);
    // }
}