class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i; j<n;j++){
                set.add(nums[j]);
                int even =0;
                int odd=0;
                for(int val : set){
                    if(val%2==0){
                        even++;
                    }else{
                        odd++;
                    }
                }
                if(even==odd){
                    int len = (j-i)+1;
                    ans = Math.max(ans,len);
                }
            }
        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }
}