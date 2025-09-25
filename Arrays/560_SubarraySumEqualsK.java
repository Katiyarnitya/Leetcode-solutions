public class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int count =0;

        //optimized 

        int[] prefix = new int[n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++){//Calculating prefix
            prefix[i]=nums[i]+prefix[i-1];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int j = 0; j < n; j++) {
            int currentSum = prefix[j];
            int req = currentSum - k;
            if(map.containsKey(req)){
                count+=map.get((req));
            }
            map.put(currentSum,map.getOrDefault(currentSum,0)+1);
        }  
        return count;
        
        // BRUTEFORCE
        // for(int i=0;i<n;i++){
        //     int sum =0;
        //     for(int j=i;j<n;j++){
        //         sum+=nums[j];
        //         if(sum==k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}{

}
