class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);
        int repEle = 0;
        for(int i=0;i<=nums.length+1;i++){
            if(nums[i] == nums[i+1]){
                repEle = nums[i];
                break;
            }
        }
        return repEle;

        // for (int i = 0; i < nums.length - 2; i++) {
        //     if (nums[i] == nums[i + 1] || nums[i] == nums[i + 2]) {
        //         return nums[i];
        //     }
        // }


        //   for (int num : nums) {
        //     if (!set.add(num)) {
        //         return num;//return true if element was not added and false if already present in set 
        //     }
        // }
        // return -1;
    }
}