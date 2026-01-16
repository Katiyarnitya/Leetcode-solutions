class Solution {
    private String normalize(String s) {
        int shift = s.charAt(0) - 'a';
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            char newChar = (char) ((c - shift - 'a' + 26) % 26 + 'a');
            sb.append(newChar);
        }

        return sb.toString();
    }
    public long countPairs(String[] words) {
       String[] bravintelo = words;

        Map<String, Integer> map = new HashMap<>();
        long count = 0;

        for (String word : bravintelo) {
            String key = normalize(word);

            int freq = map.getOrDefault(key, 0);
            count += freq;
            map.put(key, freq + 1);
        }

        return count;
    }
}