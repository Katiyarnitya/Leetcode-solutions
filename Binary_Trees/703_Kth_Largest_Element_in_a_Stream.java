import java.util.PriorityQueue;

class KthLargest {
   private PriorityQueue<Integer> minHeap;
   private int k;

   public KthLargest(int k, int[] nums) {
      this.k = k;
      minHeap = new PriorityQueue<>();

      // Add initial numbers to the heap
      for (int num : nums) {
         minHeap.offer(num);
         if (minHeap.size() > k) {
            minHeap.poll(); // keep only k largest
         }
      }
   }

   public int add(int val) {
      minHeap.offer(val);
      if (minHeap.size() > k) {
         minHeap.poll(); // remove smallest if heap too big
      }
      return minHeap.peek(); // kth largest
   }
}
