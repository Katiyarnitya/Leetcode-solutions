class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        
        int n = seq.length();
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];


        boolean canAssignB = false;
        for(int i=0;i<n;i++){
            char ch = seq.charAt(i);

            if(ch=='('){
                st.push(i);
            }else{
                int top = st.pop();
                if(canAssignB){ 
                    result[i] = 1;
                    result[top] = 1;
                }
            }
            canAssignB = !canAssignB;
        }
        return result;
    }
}