class Solution {
    public String simplifyPath(String path) {
        
        int n = path.length();
        String[] chars = path.split("/");

        Stack<String> st = new Stack<>();
        for(int i=1;i<chars.length;i++){
            
            if(chars[i].equals("") || chars[i].equals(".")){
                continue;
            }else if(chars[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();

        // For each loop on stack applies from bottom to top
        for(String dir : st){
            sb.append("/").append(dir);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}