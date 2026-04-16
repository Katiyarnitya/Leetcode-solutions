class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        
        int n = reward1.length;
        int[][] arr = new int[n][2];

        for(int i=0;i<n;i++){
            arr[i][0] = reward1[i];
            arr[i][1] = reward2[i];
        }
        Arrays.sort(arr, (a,b)-> Integer.compare((b[0] - b[1]), (a[0] - a[1])));//mouse1-mouse2 
        int profit = 0;
        for(int i=0;i<k;i++){
            profit += arr[i][0];
        }
        for(int i=k;i<n; i++){
            profit += arr[i][1];
        }
        return profit;
    }
}