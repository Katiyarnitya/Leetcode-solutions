class Solution {
   public boolean checkIfPangram(String sentence) {
      boolean[] seen = new boolean[26];

      for (char c : sentence.toCharArray()) {
         seen[c - 'a'] = true; // mark the letter as seen
      }

      for (boolean b : seen) {
         if (!b)
            return false; // if any letter is missing
      }

      return true; // all letters present
   }
}
