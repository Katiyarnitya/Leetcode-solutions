class Solution {
    // public int helper(int n, int k){
    //     if(n==1)return 0 ;

    //     int parent = helper(n-1,(k+1)/2);
    //     if(k%2 != 0){
    //         return parent;
    //     }else{
    //         return 1-parent;
    //     }
    // }
    
    public int kthGrammar(int n, int k) {
        // return helper(n,k);

        if(n==1){
            return 0;
        }
        int half = (1<<(n-1) )/2;

        if(k<=half){
            return kthGrammar(n-1,k);
        }else{
            return 1- kthGrammar(n-1,k-half);
        }
    }
}