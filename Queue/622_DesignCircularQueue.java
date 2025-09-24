class MyCircularQueue {
   private int[] arr;
   private int front;
   private int rear;
   private int size;

   public MyCircularQueue(int k) {
      // Size of array will be k
      arr = new int[k];
      front = 0;
      rear = -1;
      size = 0;
   }

   public boolean enQueue(int value) {// O(1)
      if (isFull()) {
         return false;
      }
      rear = (rear + 1) % arr.length;
      arr[rear] = value;
      size++;
      return true;
   }

   public boolean deQueue() {// O(1)
      if (isEmpty()) {
         return false;
      }
      front = (front + 1) % arr.length;
      size--;
      return true;
   }

   public int Front() {// O(1)
      if (isEmpty()) {
         return -1;
      }
      return arr[front];
   }

   public int Rear() {// O(1)
      if (isEmpty()) {
         return -1;
      }
      return arr[rear];
   }

   public boolean isEmpty() {// O(1)
      return size == 0;
   }

   public boolean isFull() {// O(1)
      return size == arr.length;
   }
}
