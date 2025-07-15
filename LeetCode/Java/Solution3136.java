package LeetCode.Java;

public class Solution3136 {
    public boolean isValid(String word) {
        if(word.length() < 3) {
            return false;
        }
        int vowels = 0;
        int consonants = 0;
        int digitC = 0;
        for(char c : word.toCharArray()) {
            if(Character.isDigit(c)) {
                digitC++;
            } else if(Character.isLetter(c)){
                char lower = Character.toLowerCase(c);
                if("aeiou".indexOf(lower)!= -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else {
                return false;
            }
        }
        if(vowels >= 1 && consonants >= 1 ){
            return true;
        } else {
            return false;
        }

    }
}
