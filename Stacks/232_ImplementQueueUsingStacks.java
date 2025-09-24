class MyQueue {

   Stack<Integer> s1;
   Stack<Integer> s2;

   public MyQueue() {
      s1 = new Stack<>();
      s2 = new Stack<>();
   }

   public void push(int x) {
      s1.push(x);
   }

   public int pop() {
      // while(!s1.isEmpty()){
      // s2.push(s1.pop());
      // }
      // int popped = s2.pop();
      // while(!s2.isEmpty()){
      // s1.push(s2.pop());
      // }
      // return popped;

      // MORE OPTIMIZED
      if (s2.isEmpty()) {
         while (!s1.isEmpty()) {
            s2.push(s1.pop());
         }
      }
      return s2.pop();
   }

   public int peek() {
      // while(!s1.isEmpty()){
      // s2.push(s1.pop());
      // }
      // int peeked = s2.peek();
      // while(!s2.isEmpty()){
      // s1.push(s2.pop());
      // }
      // return peeked;

      // MORE OPTIMIZED
      if (s2.isEmpty()) {
         while (!s1.isEmpty()) {
            s2.push(s1.pop());
         }
      }
      return s2.peek();
   }

   public boolean empty() {
      return s1.isEmpty() && s2.isEmpty();
   }
}
