class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        
        int m = reservedSeats.length;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<m;i++){
            int r = reservedSeats[i][0];
            int c = reservedSeats[i][1];
            if(c!=1 && c!=10){
                map.putIfAbsent(r, new ArrayList<>());
                map.get(r).add(c);
            }
        }
        
        int occupiedRows = map.size();
        int fourPersonGrps = (n-occupiedRows) * 2;

        
        for(int key : map.keySet() ){
            if( !map.get(key).contains(2) && !map.get(key).contains(3) && !map.get(key).contains(4) && !map.get(key).contains(5)){
                fourPersonGrps++;
                continue;
            }else if(!map.get(key).contains(4) && !map.get(key).contains(5) && !map.get(key).contains(6) && !map.get(key).contains(7)){
                fourPersonGrps++;
                continue;
            }else if(!map.get(key).contains(6) && !map.get(key).contains(7) && !map.get(key).contains(8) && !map.get(key).contains(9)){
                fourPersonGrps++;
            }

        }

        return fourPersonGrps;
    }
}