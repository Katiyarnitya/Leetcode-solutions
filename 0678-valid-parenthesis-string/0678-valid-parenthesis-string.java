class Solution {

    public boolean checkValidString(String s) {
        
        int n = s.length();
        Stack<Integer> stOpen = new Stack<>();
        Stack<Integer> stStar = new Stack<>();


        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(ch=='('){
                stOpen.push(i);
            }else if(ch==')'){
                if(!stOpen.isEmpty()){
                    stOpen.pop();
                }else{
                    if(stStar.isEmpty()){
                        return false;
                    }else{
                        stStar.pop();
                    }
                }
            }else{
                stStar.push(i);
            }
        }

        if(stOpen.isEmpty()){
            return true;
        }else{
            while (!stStar.isEmpty() && !stOpen.isEmpty()) {
    
                if (stStar.peek() > stOpen.peek()) {
                    stStar.pop();
                    stOpen.pop();
                } else {
                    return false;
                }
            }
        }
        return stOpen.isEmpty();
    }
}