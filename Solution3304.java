public class Solution3304 {
    public static char kthCharacter(int k) {
        String word = "a";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        while(word.length() < k) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int nextIndex = alphabet.indexOf(c)+1;
                next.append(alphabet.charAt(nextIndex));
            }
            word = word + next.toString();
        }
        return word.charAt(k-1);
    }

    public static void main(String[] args) {
        System.out.println("k = 5 (b): " + kthCharacter(5));
        System.out.println("k = 10 (c): " + kthCharacter(10));
    }
}
