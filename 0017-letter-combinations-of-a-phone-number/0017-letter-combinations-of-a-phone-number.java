class Solution {
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void helper(String digits, int idx, String str, List<String>ans){
        if(idx==digits.length()){
            ans.add(str);
            return;
        }
        int ch = digits.charAt(idx);
        int num = ch-'0';
        String s = map[num];
        char[] chArray = s.toCharArray();
        // We can combine all the above 4 stps into 1

        for(char c : chArray){
            helper(digits,idx+1,str+c,ans);
        }

    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        helper(digits,0,"",ans);
        return ans;
    }
}