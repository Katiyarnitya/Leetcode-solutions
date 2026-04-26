class Solution {
    public boolean checkValidString(String s) {
        
        int n = s.length();
        // Stack<Integer> openBracSt = new Stack<>(); // storing open indices
        // Stack<Integer> astricSt = new Stack<>(); // storing astric indices

        // for(int i=0;i<n;i++){
        //     if(s.charAt(i)=='('){
        //         openBracSt.push(i);
        //     }else if(s.charAt(i)=='*'){
        //         astricSt.push(i);
        //     }else{
        //         if(!openBracSt.isEmpty()){
        //             openBracSt.pop();
        //         }else if(!astricSt.isEmpty()){
        //             astricSt.pop();
        //         }else{
        //                 return false;
        //         }
        //     }
        // }
        // while(!openBracSt.isEmpty() && !astricSt.isEmpty()){
        //     if(openBracSt.peek() > astricSt.peek()){ // if the astric came before open bracket then no use
        //         return false;
        //     }
        //     astricSt.pop();
        //     openBracSt.pop();
        // }
        // return openBracSt.isEmpty();


        int close = 0;
        int open = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '(' || s.charAt(i)=='*'){
                open++;
            }else{
                open--;
            }
            if(open<0) return false;
        }

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i) == ')' || s.charAt(i)=='*'){
                close++;
            }else{
                close--;
            }
            if(close<0) return false;
        }
        return true;
    }
}

// class Solution {
//     public boolean checkValidString(String s) {
        
//         int n = s.length();
//         int min = 0;
//         int max = 0;

//         for(int i =0;i<n;i++){
//             char c = s.charAt(i);
//             if(c=='('){
//                 min+=1;
//                 max+=1;
//             }else if(c==')'){
//                 min-=1;
//                 max-=1;
//             }else{
//                 min-=1;
//                 max+=1;
//             }
//             if(min<0){
//                 min=0;
//             }
//             if(max<0){// First  character is ')', That means it can never have opening
//                 return false;
//             }
//         }
//         return (min==0);
//     }
// }