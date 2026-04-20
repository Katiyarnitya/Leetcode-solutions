class Solution {
        private int lowerBound(ArrayList<Integer> list, int target){
        
        int left = 0, right = list.size() - 1;
        int ans = list.size();
        
        while(left <= right){
            int mid = (left + right) / 2;
            
            if(list.get(mid) >= target){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        
        return ans;
    }
    public boolean increasingTriplet(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(nums[0]);
        
        for(int i = 1; i < n; i++){
            
            int num = nums[i];
            
            if(num > list.get(list.size() - 1)){
                list.add(num);
            }
            else{
                int idx = lowerBound(list, num);
                list.set(idx, num);
            }
            
            if(list.size() >= 3) return true;
        }
        
        return false;
    
    }
}