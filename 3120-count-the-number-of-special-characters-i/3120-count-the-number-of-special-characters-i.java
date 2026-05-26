class Solution {
    public int numberOfSpecialChars(String word) {

       HashSet<Character> set = new HashSet<>();
        int n = word.length();
        for(int i=0;i<n;i++){
            set.add(word.charAt(i));
        }

        int count=0;
        for(char ch ='a'; ch<='z';ch++){
            if(set.contains(ch) && set.contains(Character.toUpperCase(ch))){
                count++;
            }
        }
        return count;
    }
}