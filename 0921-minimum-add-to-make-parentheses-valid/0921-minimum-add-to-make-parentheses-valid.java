
class Solution {
    public int minAddToMakeValid(String s) {

        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }

        // Instead of using a stack we can use another variable that tracks open count
        int openCount = 0;
        int extraCloseCount = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                openCount++;
            } else {
                if (openCount <= 0) {
                    extraCloseCount++;
                } else {
                    openCount--;
                }
            }
        }

        return openCount + extraCloseCount;
    }
}

// class Solution {
//     public int minAddToMakeValid(String s) {
        
//         int n = s.length();
//         if(n==0 || n==1){
//             return n;
//         }

//         Stack<Character> stOpen = new Stack<>();
//         int extraCloseCount = 0;

//         for(char ch : s.toCharArray()){

//             if(ch=='('){
//                 stOpen.push(ch);
//             }else{
//                 if(!stOpen.isEmpty()){
//                     stOpen.pop();
//                 }else{
//                     extraCloseCount++;
//                 }
//             }
//         }
//         return stOpen.size()+extraCloseCount;
//     }
// }