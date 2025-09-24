public class Solution {
   public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String token = tokens[i];
            if(!token.equals("+")&& !token.equals("-")&& !token.equals("*")&& !token.equals("/")){
                st.push(Integer.parseInt(token);// Push the string by converting into int

            }else{
                int e1 = st.pop();
                int e2 = st.pop();
                int res =0;

                switch(token){
                    case "+" :
                    res = e2+e1;
                    break;
                    case "-" :
                    res = e2-e1;
                    break;
                    case "*" :
                    res = e2*e1;
                    break;
                    case "/" :
                    res = e2/e1;
                    break;
                }
                st.push(res);
            }
        }
        return st.pop();
    }
}{

}
