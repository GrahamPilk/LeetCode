import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2785 {
    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder result = new StringBuilder();
        int vIndex = 0;
        for(char c : s.toCharArray()) {
            if ("AEIOUaeiou".indexOf(c) != -1) {
                result.append(vowels.get(vIndex++));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}