class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
        int n = nums1.length;

        int[] diffMap = new int[(int)1e5+1]; 
        // index will act as difference Value and diff[i] will act as the frequency of that difference value

        for(int i=0; i<n;i++){
            int diff = Math.abs(nums1[i]-nums2[i]);
            diffMap[diff]++;
        }
        long k= (long)k1+k2;

        for(int i=(int)1e5 ;i>0 && k>0; i--){

            if (diffMap[i] == 0) continue;

            int operations = (int) Math.min((long) diffMap[i], k);
            diffMap[i] -= operations;
            diffMap[i-1] += operations;
            k-=operations;
        }

        long result = 0;
        for(long i = 1; i <= 1e5; i++){
            if(diffMap[(int)i] > 0){
                result += (long) diffMap[(int)i] * (i * i);
            }
        }

        return result;
    }
}

// class Solution {
//     public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        
//         int n = nums1.length;
//         PriorityQueue<Integer> diff= new PriorityQueue<>((a,b)->Integer.compare(b,a));

//         for(int i=0;i<n;i++){
//             diff.offer(Math.abs(nums1[i]-nums2[i]));
//         }
//         int k = k1+k2;

//         while(k>0 && !diff.isEmpty()){
//             int diffValue = diff.poll();
//             diffValue-=1;
//             if(diffValue>=0){
//                 diff.offer(diffValue);
//             }
//             k--;
//         }

//         long sum = 0;
//         while(!diff.isEmpty()){
//             long val = diff.poll();
//             sum += (val*val);
//         }

//         return sum;
//     }
// }