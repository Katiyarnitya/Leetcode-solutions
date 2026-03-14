import java.util.*;

class Solution {

    public boolean check(int mid, int[] arr, int n){
        return arr[mid] >= (n - mid);
    }

    public int hIndex(int[] citations) {

        int n = citations.length;

        Arrays.sort(citations);

        int l = 0;
        int h = n - 1;
        int result = 0;

        while(l <= h){

            int mid = l + (h - l) / 2;

            if(check(mid, citations, n)){
                result = n - mid;
                h = mid - 1;
            } 
            else{
                l = mid + 1;
            }
        }

        return result;
    }
}