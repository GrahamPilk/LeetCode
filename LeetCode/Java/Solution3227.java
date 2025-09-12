class Solution3227 {
    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
                return true;
        }
        return false;
    }
}

/*
 * If there is at least one vowel, Alice always has a wayu to win. Why?
 * - On her first move, she can always choose a substring with an odd number of vowels.
 * - Even if the total vowel count is even, Alice can remove a smaller odd length vowel contianing substring. After that, Bob may or may not be able to make a move, but eventually Alice will again have the chance to remove vowels. 
 * - Since the problem only asks if Alice can win, the presence of at least one vowel gurantees that there is a scenario where Alice wins. 
 * So the problem reduces to: Does the string contain at least one vowel? If yes, return true. Otherwise return false. 
 */