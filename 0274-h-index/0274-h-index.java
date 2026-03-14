class Solution {
    public boolean check(int mid , int[] arr, int n){
        return arr[mid]<= n-mid;
    }
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int[] bucket = new int[n+1];
        for(int c : citations){
            if(c>=n){
                bucket[n]++;
            }else{
                bucket[c]++;
            }
        }
        int papers = 0;
        for(int i=n;i>=1;i--){
            papers+=bucket[i];
            if(papers>=i){
                return i;
            }
        }   
        return 0;
        // if(n==1){
        //     if(citations[0]==0){
        //         return 0;
        //     }else{
        //         return 1;
        //     }
        // }
        // Arrays.sort(citations);

        // int l = 0;
        // int h = n-1;
        // int result = 0;
        // while(l<h){
        //     int mid = l+(h-l)/2;
        //     if(check(mid,citations,n)){
        //         result = citations[mid];
        //         l = mid + 1;
        //     }else{
        //         h = mid-1;
        //     }
        // }
        // return result;
    }
}