class Solution {
    public int[] resultArray(int[] nums) {
        
        int n = nums.length;
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(nums[0]);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(nums[1]);

        int i=2;

        int j=0;
        int k=0;
        while(i<n){
            if(list1.get(j)> list2.get(k)){
                list1.add(nums[i]);
                j++;
            }else{
                list2.add(nums[i]);
                k++;
            }
            i++;
        }
        int[] result = new int[n];

        i=0;
        j=0;
        while(j<list1.size()){
            result[i] = list1.get(j);
            j++;
            i++;
        }

        k=0;
        while(k<list2.size()){
            result[i] = list2.get(k);
            k++;
            i++;
        }
    return result;
    }
}