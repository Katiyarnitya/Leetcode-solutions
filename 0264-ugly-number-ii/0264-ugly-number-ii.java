class Solution {
    public int nthUglyNumber(int n) {
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();

        pq.offer(1L);
        set.add(1L);

        long ugly = 1;
        for(int i=0;i<n;i++){

            ugly = pq.poll();

            long ugly2 = ugly*2;
            long ugly3 = ugly*3;
            long ugly5 = ugly*5;

            if(!set.contains(ugly2)){
                set.add(ugly2);
                pq.offer(ugly2);
            }
            if(!set.contains(ugly3)){
                set.add(ugly3);
                pq.offer(ugly3);
            }
            if(!set.contains(ugly5)){
                set.add(ugly5);
                pq.offer(ugly5);
            }
        }
        return (int)ugly;
    }
}