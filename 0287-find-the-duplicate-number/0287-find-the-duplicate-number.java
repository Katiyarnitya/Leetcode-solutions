class Solution {
    public int findDuplicate(int[] nums) {
        
        int n = nums.length;
    
        int slow = nums[0];
        int fast = nums[0];

        slow = nums[slow];
        fast = nums[nums[fast]];

        while(slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = nums[0];
        // move 1 step at a timr
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast; // or  slow
    }
}