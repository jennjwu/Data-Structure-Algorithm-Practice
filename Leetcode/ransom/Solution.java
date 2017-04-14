import java.util.HashMap;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        String magazineUsed = magazine;

        HashMap<Character, Integer> allLetters = new HashMap<Character, Integer>();
        for (char c: magazine.toCharArray()) {
            int count = allLetters.getOrDefault(c, 0) + 1; // plus one for current iteration
            allLetters.put(c, count);
        }

        for (char c: ransomNote.toCharArray()) {
            int finalCount = allLetters.getOrDefault(c, 0) - 1; // minus one for current letter in random note
            if (finalCount < 0) { // there wasn't a matching letter in map, or it was already used
                return false;
            }
            allLetters.put(c, finalCount);
        }

        return true;
    }
}