class Solution {
    public int count(int n){
        int noOfOne = 0;
        while (n > 0) {
            if(n%2==1){
                noOfOne++;
            }
            n /= 2;
        }
        return noOfOne;
    }
    public int[] sortByBits(int[] arr) {

        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            int count1 = count(arr[i]);
            if(!map.containsKey(count1)){
                map.put(count1,new ArrayList<>());
            }
            map.get(count1).add(arr[i]);
        }
        int[] result = new int[n];
        int i=0;
        for(ArrayList<Integer> al : map.values()){
            Collections.sort(al);
            for(int j=0;j<al.size();j++){
                result[i] = al.get(j);
                i++;
            }
        }
    return result;
    }
}