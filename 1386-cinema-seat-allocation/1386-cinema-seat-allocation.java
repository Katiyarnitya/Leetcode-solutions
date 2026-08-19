class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        // int m = reservedSeats.length;

        // HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        // for(int i=0;i<m;i++){
        //     int r = reservedSeats[i][0];
        //     int c = reservedSeats[i][1];
        //     if(c!=1 && c!=10){
        //         map.putIfAbsent(r, new ArrayList<>());
        //         map.get(r).add(c);
        //     }
        // }
        
        // int occupiedRows = map.size();
        // int fourPersonGrps = (n-occupiedRows) * 2;

        
        // for(int key : map.keySet() ){
        //     if( !map.get(key).contains(2) && !map.get(key).contains(3) && !map.get(key).contains(4) && !map.get(key).contains(5)){
        //         fourPersonGrps++;
        //     }else if(!map.get(key).contains(4) && !map.get(key).contains(5) && !map.get(key).contains(6) && !map.get(key).contains(7)){
        //         fourPersonGrps++;
        //     }else if(!map.get(key).contains(6) && !map.get(key).contains(7) && !map.get(key).contains(8) && !map.get(key).contains(9)){
        //         fourPersonGrps++;
        //     }

        // }

        // return fourPersonGrps;

        // Another approahc can be instead of using arraylist for marking the reserved seats n a particular row. We can use bitmask to show the reserved seats.
        int m = reservedSeats.length;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            int r = reservedSeats[i][0];
            int c = reservedSeats[i][1];
            if(c!=1 && c!=10){
                map.put(r, (1<<c) | map.getOrDefault(r,0));
            }
        }

        int occupiedRows = map.size();
        int fourPersonGrps = (n-occupiedRows) * 2;

        int grpAMask = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int grpBMask = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int grpCMask = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for(int key : map.keySet()){

            int mask = map.get(key);
            if((mask & grpAMask )== 0){
                fourPersonGrps++;
            }else if((mask & grpBMask )== 0){
                fourPersonGrps++;
            }else if((mask & grpCMask )== 0){
                fourPersonGrps++;
            }
        }
        return fourPersonGrps;
    }
}