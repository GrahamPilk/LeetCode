class Solution3227 {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for (char c : s.toCharArray()) {
            if (isVowel(c)) vowelCount++;
        }
        // If the total number of vowels is odd, Alice wins; else, Bob wins.
        return vowelCount % 2 == 1;
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}