class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(Character.isUpperCase(ch)){
                map.putIfAbsent(ch,i);
            }else{
                map.put(ch,i);
            }
        }
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<n;i++){
            char ch = word.charAt(i);
            if(map.containsKey(Character.toLowerCase(ch)) && map.containsKey(Character.toUpperCase(ch)) && !set.contains(Character.toLowerCase(ch))){
                if(map.get(Character.toLowerCase(ch))<map.get(Character.toUpperCase(ch)) ){
                    count++;
                    set.add(Character.toLowerCase(ch));
                }
            }

        }
        return count;
    }
}