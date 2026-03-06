class Solution {
    public boolean checkOnesSegment(String s) {
      
        // int n = s.length();
        // int segment = 0;
        // int i=0;
        // while(i<n){ // O(n)
        //     if(s.charAt(i) == '1'){
        //         segment++;
        //         while(i<n && s.charAt(i)== '1'){
        //             i++;
        //         }
        //     }else{
        //         i++;
        //     }
        // }
        // if(segment>1){
        //     return false;
        // }else{
        //     return true;
        // }
        return !s.contains("01");
    }
}