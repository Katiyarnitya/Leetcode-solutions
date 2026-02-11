class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            HashSet<Integer> setE = new HashSet<>();
            HashSet<Integer> setO = new HashSet<>();
            for(int j=i; j<n;j++){
                if(nums[j] % 2==0){
                    setE.add(nums[j]);
                }else{
                    setO.add(nums[j]);
                }
                if(setE.size()==setO.size()){
                    int len = (j-i)+1;
                    ans = Math.max(ans,len);
                }
            }
        }
        return (ans == Integer.MIN_VALUE) ? 0 : ans;
    }
}