class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);

        for(int i=0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if(first!=second){
                int res = first-second;
                maxHeap.add(res);
            }

        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();

    }
}