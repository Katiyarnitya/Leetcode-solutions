class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> map.get(a) - map.get(b));

        for(int key : map.keySet()){
            pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
}

// class Solution {
//     // class ElementFreq{
//     //     int ele;
//     //     int freq;
//     //     ElementFreq(int ele, int freq){
//     //         this.ele = ele;
//     //         this.freq = freq;
//     //     }
//     // }
//     public int[] topKFrequent(int[] nums, int k) {
//         HashMap<Integer, Integer> freq = new HashMap<>();
//         for(int i : nums){
//             freq.put(i, freq.getOrDefault(i,0)+1);
//         }
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b) -> freq.get(a)-freq.get(b)); // Smaller elements on to

//         for(int num : freq.keySet()){
//             minHeap.offer(num);
//             if(minHeap.size()>k) minHeap.poll();// Removes the smallest element which is on top
//         }
//          int[] res = new int[k];
//         for(int i=0;i<k;i++){
//             res[i] = minHeap.poll();
//         }
//         // for(Map.Entry<Integer,Integer> e : map.entrySet()){
//         //     maxHeap.offer(new ElementFreq(e.getKey(), e.getValue()));
//         // }
//         // int[] res = new int[k];
//         // for(int idx =0;idx<k ;idx++){
//         //     res[idx] = maxHeap.poll().ele;
//         // }
//         return res;
//     }
// }