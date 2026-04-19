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
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return b[1] - a[1]; // height wise descending
        });

        int n = envelopes.length;
        int[] height = new int[n];

        for(int i = 0;i<n;i++){
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);

        // This can be done in opposite fashion also where we will sort on the basis of height and of height is same sort width in descending order
        // Then apply lis on width
    }
}
