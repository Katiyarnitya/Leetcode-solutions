class Solution {
    class Pair{
        char ch;
        int val;
        Pair(char ch, int val){
            this.ch = ch;
            this.val = val;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.val, x.val));
        if (a > 0) pq.offer(new Pair('a',a));
        if (b > 0) pq.offer(new Pair('b',b));
        if (c > 0)pq.offer(new Pair('c',c));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){

            Pair curr1 = pq.poll();
            char ch = curr1.ch;
            int val = curr1.val;

            if(sb.length()>=2 && sb.charAt(sb.length()-1)==ch && sb.charAt(sb.length()-2)==ch){

                if(pq.isEmpty()) break;

                Pair curr2 = pq.poll();
                sb.append(curr2.ch);
                curr2.val--;

                if(curr2.val>0) pq.offer(new Pair(curr2.ch,curr2.val));
                pq.offer(new Pair(ch,val));
            }else{
                sb.append(ch);
                val--;

                if(val>0) pq.offer(new Pair(ch,val));
            }
        }
        return sb.toString();
    }
}