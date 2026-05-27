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
            char smallCase = Character.toLowerCase(ch);
            char capitalCase = Character.toUpperCase(ch);
            if(map.containsKey(smallCase) && map.containsKey(capitalCase) && !set.contains(smallCase)){
                if(map.get(smallCase)<map.get(capitalCase) ){
                    count++;
                    set.add(smallCase);
                }
            }

        }
        return count;
    }
}