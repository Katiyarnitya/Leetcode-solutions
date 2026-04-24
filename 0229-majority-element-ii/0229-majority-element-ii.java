class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> list = new ArrayList<>();
        int count = n/3;

        for(int key : map.keySet()){
            if(map.get(key)>count){
                list.add(key);
            }
        }
        return list;
    }
}

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         int n = nums.length;

//         int count1 = 0;
//         int maj1 = -1;

//         int count2 = 0;
//         int maj2 = -1;

//         for(int i=0;i<n;i++){
//             if(maj1==nums[i]){
//                 count1++;
//             }else if(maj2 == nums[i]){
//                 count2++;
//             }else if(count1 == 0){
//                 maj1 = nums[i];
//                 count1 = 1;
//             }else if(count2==0){
//                 maj2 = nums[i];
//                 count2 = 1;
//             }else{
//                 count1--;
//                 count2--;
//             }
//         }

//         List<Integer> result = new ArrayList<>();

//         int freq1 = 0;
//         int freq2 = 0;
//         for(int i=0;i<n;i++){
//             if(nums[i] == maj1){
//                 freq1++;
//             }else if(nums[i] == maj2){
//                 freq2++;
//             }
//         }
//         if(freq1 > n/3){
//             result.add(maj1);
//         }
//         if(freq2>n/3){
//             result.add(maj2);
//         }
//         return result;
//     }
// }