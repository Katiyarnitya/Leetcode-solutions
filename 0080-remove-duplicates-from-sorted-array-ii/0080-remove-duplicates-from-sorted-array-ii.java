class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if(n <= 2) return n;

        int i = 0;
        int j = 1;
        int count = 1;

        while(j < n){
            if(nums[i] == nums[j]){
                count++;
                if(count > 2){
                    j++;
                    continue;
                }
            }else{
                count = 1;
            }

            nums[i+1] = nums[j];
            i++;
            j++;
        }

        return i+1;
    }
}