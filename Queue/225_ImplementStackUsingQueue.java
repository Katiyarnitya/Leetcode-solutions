class MyStack {
   private Queue<Integer> q1;
   private Queue<Integer> q2;

   public MyStack() {
      q1 = new LinkedList<>();
      q2 = new LinkedList<>();
   }

   public void push(int x) {
      q2.offer(x);
      while (!q1.isEmpty()) {
         q2.offer(q1.remove());// All elements are now in q2
      }
      // Swap the refrences of q1 and q2
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
   }

   public int pop() {
      return q1.remove();
   }

   public int top() {
      return q1.peek();
   }

   public boolean empty() {
      return q1.size() == 0;
   }
}
