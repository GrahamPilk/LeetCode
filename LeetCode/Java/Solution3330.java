
class Solution3330 {
    public static int possibleStringCount(String word) {
        int r = 1;
        Character c;
        for(int i = 1; i < word.length(); i++) {
            c = word.charAt(i-1);
            if (c == word.charAt(i)) {
                r++;
            }
        }
        return r;
    }

    public static void main (String[] args) {
        System.out.println("aaaa (4): " + possibleStringCount("aaaa"));
        System.out.println("abcd (1): " + possibleStringCount("abcd"));
        System.out.println("abbcccc (5): " + possibleStringCount("abbcccc"));
        System.out.println("aa (2): " + possibleStringCount("aa"));
    }
}