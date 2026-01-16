class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int count = 0;

        // int[] prefix = new int[n];
        // prefix[0] = nums[0];
        // for(int i=1;i<n;i++){
        //     prefix[i] = prefix[i-1] + nums[i];
        // }

        for(int i=0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=i; j<n; j++){
                sum += nums[j];
                set.add(nums[j]);
                if(set.contains(sum)) count++;
            }
            set.clear();
        }
        return count;
    }
}