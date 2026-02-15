class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        int n = arr.length;
        Arrays.sort(arr);// Ascending order
        int minDiff =Integer.MAX_VALUE;

        for(int i=0;i<n-1;i++){
            minDiff = Math.min(minDiff, arr[i+1]-arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==minDiff){
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                result.add(pair);
            }
        }
        return result;
    }
}